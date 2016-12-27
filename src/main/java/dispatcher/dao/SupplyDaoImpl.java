package dispatcher.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import dispatcher.entity.Provider;
import dispatcher.entity.Supply;
import dispatcher.exception.DaoException;

@Repository
@Transactional(rollbackFor = DaoException.class, noRollbackFor = Exception.class)
public class SupplyDaoImpl implements SupplyDao<Supply, String> {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void create(Integer idProvider, Supply supply) throws DaoException {
		try {
			Provider provider = manager.find(Provider.class, idProvider);
			supply.setProvider(provider);
			manager.persist(supply);
		} catch (Exception e) {
			throw new DaoException("An error has occurred in class SupplyDaoImpl, method create.", e);
		}
	}

	@Override
	public void delete(Integer idSupply) throws DaoException {
		try {
			Supply supply = manager.find(Supply.class, idSupply);
			manager.remove(supply);
		} catch (Exception e) {
			throw new DaoException("An error has occurred in class SupplyDaoImpl, method delete.", e);
		}
	}

	@Override
	public List<Supply> read() throws DaoException {
		try {
			String query = "SELECT s FROM Supply s";
			TypedQuery<Supply> supplyList = manager.createQuery(query, Supply.class);
			return supplyList.getResultList();
		} catch (Exception e) {
			throw new DaoException("An error has occurred in class SupplyDaoImpl, method read.", e);
		}
	}

	@Override
	public void update(Supply supply) throws DaoException {
		try {
			manager.merge(supply);
		} catch (Exception e) {
			throw new DaoException("An error has occurred in class SupplyDaoImpl, method update.", e);
		}
	}

	@Override
	public Supply findById(Integer idSupply) throws DaoException {
		try {
			return manager.find(Supply.class, idSupply);
		} catch (Exception e) {
			throw new DaoException("An error has occurred in class SupplyDaoImpl, method findById.", e);
		}
	}

	@Override
	public List<Supply> searchByCriteria(Integer idProvider, String department, String carNumber, LocalDate startDate,
			LocalDate endDate) throws DaoException {
		try {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<Supply> query = cb.createQuery(Supply.class);
			Root<Supply> supplyRoot = query.from(manager.getMetamodel().entity(Supply.class));
			List<Predicate> predicates = new ArrayList<Predicate>();
			if (idProvider != null) {
				predicates.add(cb.equal(supplyRoot.get("provider").get("idProvider"), idProvider));
			}
			if (department != null && !department.isEmpty()) {
				predicates.add(cb.like(supplyRoot.get("department"), department));
			}
			if (carNumber != null && !carNumber.isEmpty()) {
				predicates.add(cb.like(supplyRoot.get("carNumber"), carNumber));
			}
			if (startDate != null) {
				predicates.add(cb.greaterThanOrEqualTo(supplyRoot.<LocalDate>get("arrivalDate"), startDate));
			} else if (endDate != null) {
				predicates.add(cb.lessThanOrEqualTo(supplyRoot.<LocalDate>get("arrivalDate"), endDate));
			} else {
				predicates.add(cb.between(supplyRoot.<LocalDate>get("arrivalDate"), startDate, endDate));
			}
			query.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
			query.select(supplyRoot);
			return manager.createQuery(query).getResultList();

		} catch (Exception e) {
			throw new DaoException("An error has occurred in class SupplyDaoImpl, method searchByCriteria.", e);
		}
	}
}
