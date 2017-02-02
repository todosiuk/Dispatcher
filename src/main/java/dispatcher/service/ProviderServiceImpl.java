package dispatcher.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dispatcher.dao.ProviderDao;
import dispatcher.entity.Provider;
import dispatcher.exception.DaoException;
import dispatcher.exception.ServiceException;

@Service("providerService")
@Transactional
public class ProviderServiceImpl implements ProviderService<Provider, String> {

	@Autowired
	private ProviderDao<Provider, ?> providerDao;

	@Override
	public void create(Provider entity) throws ServiceException {
		try {
			providerDao.create(entity);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<Provider> read() throws ServiceException {
		try {
			return providerDao.read();
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void update(Provider entity) throws ServiceException {
		try {
			providerDao.update(entity);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void delete(Integer id) throws ServiceException {
		try {
			providerDao.delete(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	@Override
	public Provider findById(Integer id) throws ServiceException {
		try {
			return providerDao.findById(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	@Override
	public Provider findByName(String name) throws ServiceException {
		try {
			return providerDao.findByName(name);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
