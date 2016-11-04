package dispatcher.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
	public List<Supply> findByDepartment(String department) {
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Supply> query = cb.createQuery(Supply.class);
		Root<Supply> root = query.from(Supply.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (department != null) {
			predicates.add(cb.like(root.get("department"), department));
		}
		Predicate[] predicatesarr = predicates.toArray(new Predicate[predicates.size()]);
		query.select(root).where(predicatesarr);
		return manager.createQuery(query).getResultList();
	}

	@Override
	public List<Supply> findByCarNumber(String carNumber) {
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Supply> query = cb.createQuery(Supply.class);
		Root<Supply> root = query.from(Supply.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (carNumber != null) {
			predicates.add(cb.like(root.get("carNumber"), carNumber));
		}
		Predicate[] predicatesarr = predicates.toArray(new Predicate[predicates.size()]);
		query.select(root).where(predicatesarr);
		return manager.createQuery(query).getResultList();
	}

	@Override
	public List<Supply> findBetweenDate(LocalDate startDate, LocalDate endDate) {
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Supply> query = cb.createQuery(Supply.class);
		Root<Supply> root = query.from(Supply.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (startDate != null) {
			predicates.add(cb.between(root.<LocalDate> get("arrivalDate"), startDate, endDate));
		}
		Predicate[] predicatesarr = predicates.toArray(new Predicate[predicates.size()]);
		query.select(root).where(predicatesarr);
		return manager.createQuery(query).getResultList();
	}

}
