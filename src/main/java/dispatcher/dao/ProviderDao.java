package dispatcher.dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Component;
import dispatcher.entity.Provider;
import dispatcher.exception.DaoException;

@Component
public interface ProviderDao<Provider, String extends Serializable> {

	public void create(Provider entity) throws DaoException;

	public List<Provider> read() throws DaoException;

	public void update(Provider entity) throws DaoException;

	public void delete(Integer id) throws DaoException;

	public Provider findById(Integer id) throws DaoException;

	public Provider findByName(String name) throws DaoException;
}
