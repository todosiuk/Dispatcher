package dispatcher.dao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import dispatcher.entity.Supply;

@Component
public interface SupplyDao<T, Id extends Serializable> {

	public void create(Integer idProvider, Supply supply);

	public void delete(Integer idSupply);

	public List<T> read();

	public void update(Integer idSupply);

	public Supply findById(Integer idSupply);

	public List<T> findByDepartment(String department);

	public List<T> findByCarNumber(String carNumber);

	public List<T> findByArrivalDate(LocalDate arrivalDate);

	public List<T> findByBetweenDate(LocalDate startDate, LocalDate endDate);

}
