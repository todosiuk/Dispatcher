package dispatcher.dao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import dispatcher.entity.Provider;
import dispatcher.entity.Supply;
import dispatcher.exception.DaoException;

@Component
public interface SupplyDao<T, Id extends Serializable> {

	public void create(Integer idProvider, Supply supply) throws DaoException;

	public void delete(Integer idSupply) throws DaoException;

	public List<T> read() throws DaoException;

	public void update(Supply supply) throws DaoException;

	public Supply findById(Integer idSupply) throws DaoException;

	public List<T> searchByCriteria(Integer idProvider,String department, String carNumber, LocalDate startDate, LocalDate endDate
			) throws DaoException;
}
