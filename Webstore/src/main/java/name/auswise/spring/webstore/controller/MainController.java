package name.auswise.spring.webstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import name.auswise.spring.webstore.model.Cart;
import name.auswise.spring.webstore.model.CartItem;
import name.auswise.spring.webstore.model.Delivery;
import name.auswise.spring.webstore.model.Order;
import name.auswise.spring.webstore.model.OrderItem;
import name.auswise.spring.webstore.model.Payment;
import name.auswise.spring.webstore.model.Product;
import name.auswise.spring.webstore.model.Role;
import name.auswise.spring.webstore.model.User;
import name.auswise.spring.webstore.model.repository.CartRepository;
import name.auswise.spring.webstore.model.repository.CartRepositoryImpl;
import name.auswise.spring.webstore.model.repository.DeliveryRepository;
import name.auswise.spring.webstore.model.repository.OrderItemRepository;
import name.auswise.spring.webstore.model.repository.OrderRepository;
import name.auswise.spring.webstore.model.repository.PaymentRepository;
import name.auswise.spring.webstore.model.repository.ProductRepository;
import name.auswise.spring.webstore.model.repository.RoleRepository;
import name.auswise.spring.webstore.model.repository.UserRepository;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

@Controller
public class MainController{
 
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public MainController(){
		
	}
   
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String index(ModelMap model) {
		return "index";
	}
   
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products(ModelMap model) {
		List<Product> products = productRepository.findAll();
		model.addAttribute("products", products);
		
		return "products";
	}
	
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String account(ModelMap model) {
		User current = getCurrentUser();
		model.addAttribute("user", current);
		
		return "account";
	}
	
   
   
   @RequestMapping(value = "/account/edit", method = RequestMethod.GET)
   public String editAccount(ModelMap model){
	   
	   User current = getCurrentUser();
	   
	   model.addAttribute("user", current);
	   
	   return "editAccount";
   }
   
   @RequestMapping(value = "/account/edit", method = RequestMethod.POST)
   public String editAccount(@ModelAttribute("user") User user, BindingResult bindingResult, Model model){
	   
	   User current = getCurrentUser();
	   
	   user.setID(current.getID());
	   user.setRola(current.getRola());
	   
	   userRepository.save(user);
	   
	   return "redirect:/account";
   }
   
   private User getCurrentUser(){
	   SecurityContext context = SecurityContextHolder.getContext();
	   Authentication authentication = context.getAuthentication();
	   String login = authentication.getName();
	   User current = userRepository.findByLogin(login);
	   
	   return current;
   }
   
 //Spring Security see this :
 	@RequestMapping(value = "/login", method = RequestMethod.GET)
 	public ModelAndView login(
 		@RequestParam(value = "error", required = false) String error,
 		@RequestParam(value = "logout", required = false) String logout) {

 		ModelAndView model = new ModelAndView();
 		if (error != null) {
 			model.addObject("error", "Invalid username and password!");
 		}

 		if (logout != null) {
 			model.addObject("msg", "You've been logged out successfully.");
 		}
 		model.setViewName("login");

 		return model;

 	}

   
   
}