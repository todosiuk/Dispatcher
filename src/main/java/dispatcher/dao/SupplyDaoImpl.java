package dispatcher.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dispatcher.entity.Provider;
import dispatcher.entity.Supply;

@Repository
@Transactional
public class SupplyDaoImpl implements SupplyDao<Supply, String> {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void create(Integer idProvider, Supply supply) {
		Provider provider = manager.find(Provider.class, idProvider);
		supply.setProvider(provider);
		manager.persist(supply);
	}

	@Override
	public void delete(Integer idSupply) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Supply> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Integer idSupply) {
		// TODO Auto-generated method stub

	}

	@Override
	public Supply findById(Integer idSupply) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supply> findByDepartment(String department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supply> findByCarNumber(String carNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supply> findByArrivalDate(LocalDate arrivalDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supply> findByBetweenDate(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
