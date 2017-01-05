package dispatcher.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import dispatcher.entity.Supply;

@Controller
@RequestMapping("/exportController")
public class ExportToExcelController {

	@RequestMapping(value = "/downloadExcel", method = RequestMethod.GET)
	public ModelAndView downloadExcel(@ModelAttribute("supplyList") Supply supply, HttpServletRequest request) {
		List<Supply> list = (List<Supply>) request.getSession().getAttribute("supplyList");
		return new ModelAndView("excelView2", "supplyList", list);
	}

}
