package dispatcher.dao;

import java.util.List;

import dispatcher.entity.Provider;

public interface ProviderDao extends GenericDao<Provider, Integer> {
	
	List<Provider> findById(Integer id);
	List<Provider> findByName(String name);

}
