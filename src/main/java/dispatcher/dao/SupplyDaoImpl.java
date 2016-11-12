package dispatcher.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import dispatcher.entity.Provider;
import dispatcher.entity.Supply;

@Repository
@Transactional
public class SupplyDaoImpl implements SupplyDao<Supply, String> {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void create(Integer idProvider, Supply supply) {
		Provider provider = manager.find(Provider.class, idProvider);
		supply.setProvider(provider);
		manager.persist(supply);
	}

	@Override
	public void delete(Integer idSupply) {
		Supply supply = manager.find(Supply.class, idSupply);
		manager.remove(supply);
	}

	@Override
	public List<Supply> read() {
		String query = "SELECT s FROM Supply s";
		TypedQuery<Supply> supplyList = manager.createQuery(query, Supply.class);
		return supplyList.getResultList();
	}

	@Override
	public void update(Supply supply) {
		manager.merge(supply);
	}

	@Override
	public Supply findById(Integer idSupply) {
		return manager.find(Supply.class, idSupply);
	}

	@Override
	public List<Supply> searchByCriteria(String department, String carNumber, LocalDate startDate, LocalDate endDate,
			Integer idProvider) {
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Supply> query = cb.createQuery(Supply.class);
		Root<Supply> root = query.from(Supply.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (department != null) {
			predicates.add(cb.like(root.get("department"), department));
		}
		if (carNumber != null) {
			predicates.add(cb.like(root.get("carNumber"), carNumber));
		}
		if (startDate != null) {
			predicates.add(cb.between(root.<LocalDate> get("arrivalDate"), startDate, endDate));
		}
		if (idProvider != null) {
			predicates.add(cb.equal(root.get("provider"), idProvider));
		}
		Predicate[] predicatesarr = predicates.toArray(new Predicate[predicates.size()]);
		query.select(root).where(predicatesarr);
		return manager.createQuery(query).getResultList();
	}
}
