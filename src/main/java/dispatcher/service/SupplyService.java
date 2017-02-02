package dispatcher.service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import dispatcher.entity.Supply;
import dispatcher.exception.ServiceException;

public interface SupplyService<T, Id extends Serializable> {

	public void create(Integer idProvider, Supply supply) throws ServiceException;

	public void delete(Integer idSupply) throws ServiceException;

	public List<T> read() throws ServiceException;

	public void update(Supply supply) throws ServiceException;

	public Supply findById(Integer idSupply) throws ServiceException;

	public List<T> searchByCriteria(Integer idProvider, String department, String carNumber, LocalDate startDate,
			LocalDate endDate) throws ServiceException;
}
