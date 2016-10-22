package dispatcher.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dispatcher.entity.Provider;

@Repository
@Transactional
public class ProviderDaoImpl implements ProviderDao<Provider, String> {

	// An EntityManager will be automatically injected from EntityManagerFactory
	// setup on
	// springContext.xml
	@PersistenceContext
	private EntityManager manager;

	// Since we've setup <tx:annotation-config> and transaction manager on
	// springContext.xml,
	// any bean method annotated with @Transactional will cause Spring to
	// magically call
	// begin() and commit() at the start/end of the method. If exception occurs
	// it will also
	// call rollback()
	
	@Override
	public void create(Provider provider) {
		manager.persist(provider);
	}

	@Override
	public List<Provider> read() {
		String sqlString = "SELECT p FROM Provider p";
		TypedQuery<Provider> query = manager.createQuery(sqlString, Provider.class);
		return query.getResultList();
	}

	@Override
	public void update(Provider provider) {
		manager.merge(provider);
	}

	@Override
	public void delete(Integer idProvider) {
		Provider provider = manager.find(Provider.class, idProvider);
		manager.remove(provider);
	}

	@Override
	public Provider findById(Integer idProvider) {
		return manager.find(Provider.class, idProvider);
	}

	@Override
	public Provider findByName(String nameProvider) {
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Provider> nameLikeCriteria = cb.createQuery(Provider.class);
		Root<Provider> likeProviderRoot = nameLikeCriteria.from(Provider.class);
		nameLikeCriteria.select(likeProviderRoot);
		ParameterExpression<String> parameter = cb.parameter(String.class);
		nameLikeCriteria.where(cb.like(likeProviderRoot.get("nameProvider"), nameProvider));
		return manager.createQuery(nameLikeCriteria).getSingleResult();
	}

}
