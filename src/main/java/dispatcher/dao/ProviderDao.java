package dispatcher.dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Component;
import dispatcher.entity.Provider;

@Component
public interface ProviderDao<Provider, String extends Serializable> {

	public void create(Provider entity);

	public List<Provider> read();

	public void update(Provider entity);

	public void delete(Integer id);

	public Provider findById(Integer id);

	public Provider findByName(String name);
}
