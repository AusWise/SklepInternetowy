package name.auswise.spring.webstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import name.auswise.spring.webstore.model.Producer;
import name.auswise.spring.webstore.model.Product;
import name.auswise.spring.webstore.model.ProductType;
import name.auswise.spring.webstore.model.User;
import name.auswise.spring.webstore.model.repository.ProducerRepository;
import name.auswise.spring.webstore.model.repository.ProductRepository;
import name.auswise.spring.webstore.model.repository.ProductTypeRepository;
import name.auswise.spring.webstore.model.repository.UserRepository;

public class EmployeeController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductTypeRepository productTypeRepository;
	
	@Autowired
	ProducerRepository producerRepository;
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	   public String employee(ModelMap model) {
		   User current = getCurrentUser();
		   model.addAttribute("current", current);
		   
		   return "employee";
	   }
	
	@RequestMapping(value = "/productsManagment", method = RequestMethod.GET)
	   
	
	public String productsManagment(ModelMap model) {
		   List<Product> products = productRepository.findAll();
		   model.addAttribute("products", products);
		   
		   return "productsManagment";
	   }
	
	private User getCurrentUser(){
		   SecurityContext context = SecurityContextHolder.getContext();
		   Authentication authentication = context.getAuthentication();
		   String login = authentication.getName();
		   User current = userRepository.findByLogin(login);
		   
		   return current;
	   }
	   
	   @RequestMapping(value = "/productsManagment/edit", method = RequestMethod.GET)
	   public String editProduct(
			   Long id, 
			   Model model){
		   
		   List<Producer> producers = producerRepository.findAll();
		   model.addAttribute("producers", producers);
		   
		   List<ProductType> productTypes = productTypeRepository.findAll();
		   model.addAttribute("productTypes", productTypes);
		   
		   Product product = productRepository.findOne(id);
		   model.addAttribute("product", product);
		   
		   return "editProduct";
	   }
	   
	   @RequestMapping(value = "/productsManagment/edit", method = RequestMethod.POST)
	   public String editProduct(@RequestParam String producent, @RequestParam String typProduktu, @ModelAttribute("product") Product product, BindingResult bindingResult, Model model){
		   Producer producer = producerRepository.findByNazwa(producent);
		   ProductType productType = productTypeRepository.findByNazwa(typProduktu);
		   product.setTypProduktu(productType);
		   product.setProducent(producer);
		   productRepository.save(product);
		   return "redirect:/productManagment";
	   }
	   
	   @RequestMapping(value = "/productsManagment/new", method = RequestMethod.GET)
	   public String newProduct(Model model){
		   model.addAttribute("product", new Product());
		   List<Producer> producers = producerRepository.findAll();
		   model.addAttribute("producers", producers);
		   List<ProductType> productTypes = productTypeRepository.findAll();
		   model.addAttribute("productTypes", productTypes);
		   return "newProduct";
	   }
	   
	   @RequestMapping(value = "/productsManagment/new", method = RequestMethod.POST)
	   public String newProduct(@RequestParam String producent, @RequestParam String typProduktu, @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
		   Producer producer = producerRepository.findByNazwa(producent);
		   ProductType productType = productTypeRepository.findByNazwa(typProduktu);
		   product.setTypProduktu(productType);
		   product.setProducent(producer);
		   productRepository.save(product);
		   return "redirect:/productManagment";
	   }
	   
	   @RequestMapping(value = "/productsManagment/remove", method = RequestMethod.GET)
	   public String deleteProduct(Long id, Model model){
		   productRepository.delete(id);
		   return "redirect:/productManagment";
	   }
}
