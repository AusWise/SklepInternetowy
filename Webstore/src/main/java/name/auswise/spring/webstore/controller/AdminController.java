package name.auswise.spring.webstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import name.auswise.spring.webstore.model.Role;
import name.auswise.spring.webstore.model.User;
import name.auswise.spring.webstore.model.repository.RoleRepository;
import name.auswise.spring.webstore.model.repository.UserRepository;

@Controller
public class AdminController {
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRepository userRepository;
	
		@RequestMapping(value = "/admin", method = RequestMethod.GET)
	 	public String admin(ModelMap model) {
		   User current = getCurrentUser();
		   model.addAttribute("current", current);

		   return "admin";
	   }
		
		private User getCurrentUser(){
			   SecurityContext context = SecurityContextHolder.getContext();
			   Authentication authentication = context.getAuthentication();
			   String login = authentication.getName();
			   User current = userRepository.findByLogin(login);
			   
			   return current;
		   }
		
	   @RequestMapping(value = "/usersManagment", method = RequestMethod.GET)
	   public String usersManagment(ModelMap model) {
		   List<User> users = userRepository.findAll();
		   model.addAttribute("users", users);
		   
		   return "usersManagment";
	   }
	   
	   @RequestMapping(value = "/usersManagment/edit", method = RequestMethod.GET)
	   public String editUser(
			   Long id, 
			   Model model){
		   
		   List<Role> roles = roleRepository.findAll();
		   model.addAttribute("roles", roles);
		   
		   User user = userRepository.findOne(id);
		   model.addAttribute("user", user);
		   
		   return "editUser";
	   }
	   
	   @RequestMapping(value = "/usersManagment/edit", method = RequestMethod.POST)
	   public String editUser(@RequestParam String rola, @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
		   Role role = roleRepository.findByNazwa(rola);
		   user.setRola(role);
		   userRepository.save(user);
		   return "redirect:/usersManagment";
	   }
	   
	   @RequestMapping(value = "/usersManagment/new", method = RequestMethod.GET)
	   public String newUser(Model model){
		   model.addAttribute("user", new User());
		   List<Role> roles = roleRepository.findAll();
		   model.addAttribute("roles", roles);
		   return "newUser";
	   }
	   
	   @RequestMapping(value = "/usersManagment/new", method = RequestMethod.POST)
	   public String newUser(@RequestParam String rola, @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
		   Role role = roleRepository.findByNazwa(rola);
		   user.setRola(role);
		   userRepository.save(user);
		   
		   return "redirect:/usersManagment";
	   }
	   
	   @RequestMapping(value = "/usersManagment/remove", method = RequestMethod.GET)
	   public String deleteUser(Long id, Model model){
		   userRepository.delete(id);
		   return "redirect:/usersManagment";
	   }	
}
