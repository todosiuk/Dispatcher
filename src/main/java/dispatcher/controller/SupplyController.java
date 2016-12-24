package dispatcher.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import dispatcher.dao.ProviderDaoImpl;
import dispatcher.dao.SupplyDaoImpl;
import dispatcher.entity.Supply;
import dispatcher.exception.DaoException;

@Controller
@RequestMapping("/supplyController")
public class SupplyController {

	@Autowired
	private SupplyDaoImpl supplyDao;

	@Autowired
	private ProviderDaoImpl providerDao;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showFormOfAddingSupply(@RequestParam(value = "idProvider", required = true) Integer idProvider,
			Model model) throws DaoException {
		Supply supply = new Supply();
		supply.setProvider(providerDao.findById(idProvider));
		model.addAttribute("supplyAttribute", supply);
		return "formOfAddingSupply";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addingSupply(@RequestParam(value = "idProvider", required = true) Integer idProvider,
			@ModelAttribute("supplyAttribute") Supply supply, Model model) throws DaoException {
		supply.setarrivalDate(LocalDate.now());
		supplyDao.create(idProvider, supply);
		model.addAttribute("msg", "Поставка успешно добавлена");
		return "success";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteSupply(@RequestParam(value = "idSupply", required = true) Integer idSupply)
			throws DaoException {
		supplyDao.delete(idSupply);
		return "success";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String showFormOfUpdatingSupply(@RequestParam(value = "idProvider", required = true) Integer idProvider,
			@RequestParam(value = "idSupply", required = true) Integer idSupply, Model model) throws DaoException {
		Supply supply = new Supply();
		supply.setProvider(providerDao.findById(idProvider));
		model.addAttribute("idProvider", idProvider);
		model.addAttribute("supplyAttribute", supplyDao.findById(idSupply));
		return "formOfUpdatingSupply";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatingSupply(@RequestParam(value = "idProvider", required = true) Integer idProvider,
			@RequestParam(value = "idSupply", required = true) Integer idSupply,
			@ModelAttribute("supplyAttribute") Supply supply) throws DaoException {
		supply.setIdSupply(idSupply);
		supplyDao.update(supply);
		return "success";
	}

	@RequestMapping(value = "/searchForm", method = RequestMethod.GET)
	public String showSearchForm(@RequestParam(value = "idProvider", required = true) Integer idProvider, Model model)
			throws DaoException {
		Supply supply = new Supply();
		supply.setProvider(providerDao.findById(idProvider));
		model.addAttribute("idAttribute", supply);
		return "formOfSearch";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@RequestParam Integer idProvider,
			@RequestParam String department,
			@RequestParam String carNumber,
			@RequestParam ("arrivalDate") @DateTimeFormat(iso = ISO.DATE) LocalDate startDate,
			@RequestParam("arrivalDate") @DateTimeFormat(iso = ISO.DATE) LocalDate endDate,
			@ModelAttribute("idAttribute") Supply supply, Model model) throws DaoException {

		List<Supply> supplyList = supplyDao.searchByCriteria(idProvider, department, carNumber, startDate, endDate);
		model.addAttribute("supplyList", supplyList);

		return "searchList";
	}

}
