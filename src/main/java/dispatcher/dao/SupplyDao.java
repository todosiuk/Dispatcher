package dispatcher.dao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import dispatcher.entity.Provider;
import dispatcher.entity.Supply;

@Component
public interface SupplyDao<T, Id extends Serializable> {

	public void create(Integer idProvider, Supply supply);

	public void delete(Integer idSupply);

	public List<T> read();

	public void update(Supply supply);

	public Supply findById(Integer idSupply);

	public List<T> searchByCriteria(String department, String carNumber, LocalDate startDate, LocalDate endDate,
			Integer idProvider);
}
