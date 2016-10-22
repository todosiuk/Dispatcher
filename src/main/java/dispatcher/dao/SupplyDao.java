package dispatcher.dao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface SupplyDao<T, Id extends Serializable> {

	public void create(Integer id, T entity);

	public void delete(Integer id);

	public List<T> read();

	public void update(Integer id);

	public T findById(Integer id);

	public List<T> findByDepartment(String department);

	public List<T> findByCarNumber(String carNumber);

	public List<T> findByArrivalDate(LocalDate arrivalDate);

	public List<T> findByBetweenDate(LocalDate startDate, LocalDate endDate);

}
