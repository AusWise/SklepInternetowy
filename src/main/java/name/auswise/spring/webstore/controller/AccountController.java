package name.auswise.spring.webstore.controller;

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

import name.auswise.spring.webstore.UserValidator;
import name.auswise.spring.webstore.model.User;
import name.auswise.spring.webstore.service.UserService;

@Controller
public class AccountController {
	
	@Autowired
	UserValidator userValidator;
	
	@Autowired
	UserService userService;
	
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
	   userValidator.validate(user, bindingResult);
		
		if (bindingResult.hasErrors()) {
           return "editAccount";
       }

		userService.save(user);
	   
	   return "redirect:/account";
   }
   
   private User getCurrentUser(){
	   SecurityContext context = SecurityContextHolder.getContext();
	   Authentication authentication = context.getAuthentication();
	   String login = authentication.getName();
	   User current = userService.findByLogin(login);
	   
	   return current;
   }
}
