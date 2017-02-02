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
import dispatcher.exception.DaoException;
import dispatcher.exception.ServiceException;
import dispatcher.service.ProviderServiceImpl;

@Controller
@RequestMapping("/providerController")
public class ProviderController {

	@Autowired
	private ProviderServiceImpl providerService;

	@RequestMapping(value = "/providers", method = RequestMethod.GET)
	public String getProviders(Model model) throws ServiceException {
		List<Provider> providers = providerService.read();
		model.addAttribute("providers", providers);
		return "providersList";
	}

	@RequestMapping(value = "/providers/add", method = RequestMethod.GET)
	public String showFormOfAddingProvider(Model model) {
		model.addAttribute("providerAttribute", new Provider());
		return "formOfAddingProvider";
	}

	@RequestMapping(value = "/providers/add", method = RequestMethod.POST)
	public String addingProvider(@ModelAttribute("providerAttribute") Provider provider, Model model)
			throws ServiceException {
		providerService.create(provider);
		model.addAttribute("msg", "Вы успешно добавили поставщика " + provider.getProviderName());
		return "success";
	}

	@RequestMapping(value = "/providers/delete", method = RequestMethod.GET)
	public String deleteProvider(@RequestParam(value = "idProvider", required = true) Integer idProvider, Model model)
			throws ServiceException {
		providerService.delete(idProvider);
		model.addAttribute("idProvider", idProvider);
		model.addAttribute("msg", "Вы успешно удалили поставщика");
		return "success";
	}

	@RequestMapping(value = "/providers/update", method = RequestMethod.GET)
	public String showFormOfUpdatingProvider(@RequestParam(value = "idProvider", required = true) Integer idProvider,
			Model model) throws ServiceException {
		model.addAttribute("providerAttribute", providerService.findById(idProvider));
		return "formOfUpdatingProvider";
	}

	@RequestMapping(value = "/providers/update", method = RequestMethod.POST)
	public String updatingProvider(@ModelAttribute("providerAttribute") Provider provider,
			@RequestParam(value = "idProvider", required = true) Integer idProvider, Model model)
			throws ServiceException {
		provider.setIdProvider(idProvider);
		providerService.update(provider);
		model.addAttribute("idProvider", idProvider);
		model.addAttribute("msg", "Поставщик " + provider.getProviderName() + " успешно обновлен");
		return "success";
	}

	@RequestMapping(value = "/providers/searchByName", method = RequestMethod.GET)
	public String searchProviderByName(@RequestParam(value = "providerName", required = true) String providerName,
			Model model) throws ServiceException {
		Provider provider = providerService.findByName(providerName);
		model.addAttribute("provider", provider);
		return "searchProviderByName";
	}

}
