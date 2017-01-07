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
@RequestMapping(value = "/pdf", method = RequestMethod.GET)
public class ReportController {

	public ModelAndView generatePdfReport(@ModelAttribute("supplyList") Supply supply, HttpServletRequest request) {

		List<Supply> supplyList = (List<Supply>) request.getAttribute("supplyList");
		return new ModelAndView("pdfView", "supplyList", supplyList);
	}
}
