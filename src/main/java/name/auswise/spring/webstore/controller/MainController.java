package name.auswise.spring.webstore.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import name.auswise.spring.webstore.model.Product;
import name.auswise.spring.webstore.service.ProductService;

@Controller
public class MainController{

	@Autowired
	ProductService productService;
	
	@RequestMapping(value = {"/", "/products"}, method = RequestMethod.GET)
	public String products(Locale locale, ModelMap model) {
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		
		return "products";
	}

 	@RequestMapping(value="/test", method = RequestMethod.GET)
 	public ModelAndView test(Locale locale){
 		ModelAndView model = new ModelAndView();
 		model.setViewName("test");
 		return model;
 	}
}