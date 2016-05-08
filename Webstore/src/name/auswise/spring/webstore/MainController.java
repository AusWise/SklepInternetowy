package name.auswise.spring.webstore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

@Controller
public class MainController{
 
   @RequestMapping(value = "/hello", method = RequestMethod.GET)
   public String hello(ModelMap model) {
      model.addAttribute("message", "Hello Spring MVC Framework!");
      return "hello";
   }
   
   @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
   public String index(ModelMap model) {
	   return "index";
   }
   
   @RequestMapping(value = "/products", method = RequestMethod.GET)
   public String products(ModelMap model) {
	   return "products";
   }
   
   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public String login(ModelMap model) {
	   return "login";
   }
   
   @RequestMapping(value = "/user", method = RequestMethod.GET)
   public String user(ModelMap model) {
	   return "user";
   }
}