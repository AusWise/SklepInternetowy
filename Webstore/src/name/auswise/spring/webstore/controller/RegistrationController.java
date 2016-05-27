package name.auswise.spring.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import name.auswise.spring.webstore.UserService;
import name.auswise.spring.webstore.UserValidator;
import name.auswise.spring.webstore.model.Role;
import name.auswise.spring.webstore.model.User;
import name.auswise.spring.webstore.model.repository.RoleRepository;
import name.auswise.spring.webstore.model.repository.UserRepository;

@Controller
public class RegistrationController {
	
	@Autowired
	UserValidator userValidator;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}
	   
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {		
		userValidator.validate(user, bindingResult);
		
		if (bindingResult.hasErrors()) {
            return "registration";
        }

		userService.save(user);
		   
		return "redirect:/";
	}
}
