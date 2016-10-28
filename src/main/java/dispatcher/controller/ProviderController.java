package dispatcher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dispatcher.dao.ProviderDaoImpl;
import dispatcher.entity.Provider;

@Controller
@RequestMapping("/providerController")
public class ProviderController {

	@Autowired
	private ProviderDaoImpl providerDao;

	@RequestMapping(value = "/providers", method = RequestMethod.GET)
	public String getProviders(Model model) {
		List<Provider> providers = providerDao.read();
		model.addAttribute("providers", providers);
		return "providersList";
	}

	@RequestMapping(value = "/providers/add", method = RequestMethod.GET)
	public String showFormOfAddingProvider(Model model) {
		model.addAttribute("providerAttribute", new Provider());
		return "formOfAddingProvider";
	}

	@RequestMapping(value = "/providers/add", method = RequestMethod.POST)
	public String addingProvider(@ModelAttribute("providerAttribute") Provider provider) {
		providerDao.create(provider);
		return "providersList";
	}

	@RequestMapping(value = "providers/delete", method = RequestMethod.GET)
	public String deleteProvider(@RequestParam(value = "idProvider", required = true) Integer idProvider, Model model) {
		providerDao.delete(idProvider);
		model.addAttribute("idProvider", idProvider);
		return "providersList";
	}

	@RequestMapping(value = "/providers/update", method = RequestMethod.GET)
	public String showFormOfUpdatingProvider(@RequestParam(value = "idProvider", required = true) Integer idProvider,
			Model model) {
		model.addAttribute("providerAttribute", providerDao.findById(idProvider));
		return "formOfUpdatingProvider";
	}

	@RequestMapping(value = "/providers/update", method = RequestMethod.POST)
	public String updatingProvider(@ModelAttribute("providerAttribute") Provider provider,
			@RequestParam(value = "idProvider", required = true) Integer idProvider, Model model) {
		provider.setIdProvider(idProvider);
		providerDao.update(provider);
		model.addAttribute("idProvider", idProvider);
		return "providersList";
	}
	
	

}
