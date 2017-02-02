package dispatcher.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dispatcher.dao.SupplyDao;
import dispatcher.entity.Supply;
import dispatcher.exception.DaoException;
import dispatcher.exception.ServiceException;

@Service("supplyService")
@Transactional
public class SupplyServiceImpl implements SupplyService<Supply, String> {

	@Autowired
	private SupplyDao<Supply, ?> supplyDao;

	@Override
	public void create(Integer idProvider, Supply supply) throws ServiceException {
		try {
			supplyDao.create(idProvider, supply);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void delete(Integer idSupply) throws ServiceException {
		try {
			supplyDao.delete(idSupply);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	@Override
	public List<Supply> read() throws ServiceException {
		try {
			return supplyDao.read();
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	@Override
	public void update(Supply supply) throws ServiceException {
		try {
			supplyDao.update(supply);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	@Override
	public Supply findById(Integer idSupply) throws ServiceException {
		try {
			return supplyDao.findById(idSupply);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<Supply> searchByCriteria(Integer idProvider, String department, String carNumber, LocalDate startDate,
			LocalDate endDate) throws ServiceException {
		try {
			return supplyDao.searchByCriteria(idProvider, department, carNumber, startDate, endDate);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
