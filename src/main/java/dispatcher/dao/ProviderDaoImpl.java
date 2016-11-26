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
import dispatcher.exception.DaoException;

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
	public void create(Provider provider) throws DaoException {
		try {
			manager.persist(provider);
		} catch (Exception e) {
			throw new DaoException("An error has occurred in class ProviderDaoImpl, method create.", e);
		}
	}

	@Override
	public List<Provider> read() throws DaoException {
		try {
			String sqlString = "SELECT p FROM Provider p ORDER BY p.providerName";
			TypedQuery<Provider> query = manager.createQuery(sqlString, Provider.class);
			return query.getResultList();
		} catch (Exception e) {
			throw new DaoException("An error has occurred in class ProviderDaoImpl, method read.", e);
		}
	}

	@Override
	public void update(Provider provider) throws DaoException {
		try {
			manager.merge(provider);
		} catch (Exception e) {
			throw new DaoException("An error has occurred in class ProviderDaoImpl, method update.", e);
		}
	}

	@Override
	public void delete(Integer idProvider) throws DaoException {
		try {
			Provider provider = manager.find(Provider.class, idProvider);
			manager.remove(provider);
		} catch (Exception e) {
			throw new DaoException("An error has occurred in class ProviderDaoImpl, method delete.", e);
		}
	}

	@Override
	public Provider findById(Integer idProvider) throws DaoException {
		try {
			return manager.find(Provider.class, idProvider);
		} catch (Exception e) {
			throw new DaoException("An error has occurred in class ProviderDaoImpl, method findById.", e);
		}
	}

	@Override
	public Provider findByName(String providerName) throws DaoException {
		try {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<Provider> nameLikeCriteria = cb.createQuery(Provider.class);
			Root<Provider> likeProviderRoot = nameLikeCriteria.from(Provider.class);
			nameLikeCriteria.select(likeProviderRoot);
			ParameterExpression<String> parameter = cb.parameter(String.class);
			nameLikeCriteria.where(cb.like(likeProviderRoot.get("providerName"), providerName));
			return manager.createQuery(nameLikeCriteria).getSingleResult();
		} catch (Exception e) {
			throw new DaoException("An error has occurred in class ProviderDaoImpl, method findByName.", e);
		}
	}

}
