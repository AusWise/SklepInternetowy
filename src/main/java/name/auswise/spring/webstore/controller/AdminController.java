package name.auswise.spring.webstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import name.auswise.spring.webstore.RegistrationValidator;
import name.auswise.spring.webstore.UserValidator;
import name.auswise.spring.webstore.model.Role;
import name.auswise.spring.webstore.model.User;
import name.auswise.spring.webstore.service.RoleService;
import name.auswise.spring.webstore.service.UserService;

@Controller
public class AdminController {
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	UserValidator userValidator;
	
	@Autowired
	RegistrationValidator registrationValidator;
	
	@Autowired 
	UserService userService;
	
	@RequestMapping(value = "/usersManagment", method = RequestMethod.GET)
	public String usersManagment(ModelMap model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		
		return "usersManagment";
	}
	   
	@RequestMapping(value = "/usersManagment/edit", method = RequestMethod.GET)
	public String editUser(Long id, Model model){
		
		if(id==null)
			return "redirect:/usersManagment";
		
		List<Role> roles = roleService.findAll();
		model.addAttribute("roles", roles);
		   
		User user = userService.findOne(id);
		model.addAttribute("user", user);
		   
		return "editUser";
	}
	   
	   
	@RequestMapping(value = "/usersManagment/edit", method = RequestMethod.POST)
	public String editUser(@ModelAttribute("user") User user, BindingResult bindingResult, Model model){
		List<Role> roles = roleService.findAll();
		model.addAttribute("roles", roles);		   
	
		userValidator.validate(user, bindingResult);			
		
		if (bindingResult.hasErrors()) {
			return "editUser";
		}
		
		userService.save(user);		   
		
		return "redirect:/usersManagment";
	}
	   
	@RequestMapping(value = "/usersManagment/new", method = RequestMethod.GET)
	public String newUser(Model model){
		model.addAttribute("user", new User());	
		
		List<Role> roles = roleService.findAll();
		model.addAttribute("roles", roles);
		
		return "newUser";
	}
	   
	@RequestMapping(value = "/usersManagment/new", method = RequestMethod.POST)
	public String newUser(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
		List<Role> roles = roleService.findAll();
		model.addAttribute("roles", roles);
	
		registrationValidator.validate(user, bindingResult);
		
		if (bindingResult.hasErrors()) {
			return "newUser";
		}
		
		userService.save(user);
		
		return "redirect:/usersManagment";
	}
	   
	@RequestMapping(value = "/usersManagment/remove", method = RequestMethod.GET)
	public String deleteUser(Long id, Model model){
		if(id==null)
			return "redirect:/usersManagment";
		
		userService.delete(id);
		
		return "redirect:/usersManagment";
	}	
}
