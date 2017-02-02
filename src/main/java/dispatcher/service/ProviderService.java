package dispatcher.service;

import java.io.Serializable;
import java.util.List;

import dispatcher.exception.ServiceException;

public interface ProviderService<Provider, Id extends Serializable> {

	public void create(Provider entity) throws ServiceException;

	public List<Provider> read() throws ServiceException;

	public void update(Provider entity) throws ServiceException;

	public void delete(Integer id) throws ServiceException;

	public Provider findById(Integer id) throws ServiceException;

	public Provider findByName(String name) throws ServiceException;

}
