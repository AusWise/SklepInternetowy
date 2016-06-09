package name.auswise.spring.webstore.controller;


import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


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

import name.auswise.spring.webstore.PieChartService;
import name.auswise.spring.webstore.PieChartData.KeyValue;
import name.auswise.spring.webstore.model.Producer;
import name.auswise.spring.webstore.model.Product;
import name.auswise.spring.webstore.model.OrderItem;
import name.auswise.spring.webstore.model.Order;
import name.auswise.spring.webstore.model.ProductType;
import name.auswise.spring.webstore.model.User;
import name.auswise.spring.webstore.model.repository.ProducerRepository;
import name.auswise.spring.webstore.model.repository.ProductRepository;
import name.auswise.spring.webstore.model.repository.ProductTypeRepository;
import name.auswise.spring.webstore.model.repository.UserRepository;
import name.auswise.spring.webstore.service.OrderItemService;
import name.auswise.spring.webstore.service.ProducerService;
import name.auswise.spring.webstore.service.ProductService;
import name.auswise.spring.webstore.service.ProductTypeService;

@Controller
public class EmployeeController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductTypeService productTypeService;
	
	@Autowired
	ProducerService producerService;
	
	@Autowired
	OrderItemService orderItemService;
	
	@Autowired
    private PieChartService pieChartService;
	
	@RequestMapping(value = "/productsManagment", method = RequestMethod.GET)
	public String productsManagment(ModelMap model) {
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		
		return "productsManagment";
	}
	
	@RequestMapping(value = "/productsManagment/edit", method = RequestMethod.GET)
	public String editProduct(Long id, Model model){
		List<Producer> producers = producerService.findAll();
		model.addAttribute("producers", producers);
		
		List<ProductType> productTypes = productTypeService.findAll();
		model.addAttribute("productTypes", productTypes);
		
		Product product = productService.findOne(id);
		model.addAttribute("product", product);
		
		return "editProduct";
	}
	   
	   @RequestMapping(value = "/productsManagment/edit", method = RequestMethod.POST)
	   public String editProduct(@ModelAttribute("product") Product product, BindingResult bindingResult, Model model){
		   productService.save(product);
		   
		   return "redirect:/productsManagment";
	   }
	   
	   @RequestMapping(value = "/productsManagment/new", method = RequestMethod.GET)
	   public String newProduct(Model model){
		   model.addAttribute("product", new Product());
		   
		   List<Producer> producers = producerService.findAll();
		   model.addAttribute("producers", producers);
		   
		   List<ProductType> productTypes = productTypeService.findAll();
		   model.addAttribute("productTypes", productTypes);
		   
		   return "newProduct";
	   }
	   
	   @RequestMapping(value = "/productsManagment/new", method = RequestMethod.POST)
	   public String newProduct(@ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
		   productService.save(product);
		   
		   return "redirect:/productsManagment";
	   }
	   
	   @RequestMapping(value = "/productsManagment/remove", method = RequestMethod.GET)
	   public String deleteProduct(Long id, Model model){
		   if(id==null)
			   return "redirect:/productsManagment";
		   
		   productService.delete(id);
		   return "redirect:/productsManagment";
	   }
	   
	   @RequestMapping(value="/chart",  method = RequestMethod.GET)
	   public String chart(Integer month, Integer year, ModelMap modelMap) {
//	        List<KeyValue> pieDataList = pieChartService.getPieChartData();
//	        modelMap.addAttribute("pieDataList", pieDataList);
//	        return "spring";
		   
		   		   
		   System.out.println(month);
		   System.out.println(year);
		   
		   Map<Product, Integer> chartDataMap = new HashMap<Product, Integer>();
		   List<Product> products = productService.findAll();
		   List<OrderItem> orderItems = orderItemService.findAll();
		  
		   for(Product product: products)
			   chartDataMap.put(product, 0);
		  
		   Product product;
		   int quantity;
		   Date date;
		   Order order;
		   for(OrderItem orderItem: orderItems){
			   order = orderItem.getOrder();
			   date = order.getData();
			   
			   if(
					   (month==null || month==getMonth(date)) && 
					   (year==null || year==getYear(date))
				)
			   
			   {
				   product = orderItem.getProduct();
				   quantity = chartDataMap.get(product);
				   quantity += orderItem.getLiczba();
				   
				   chartDataMap.put(product, quantity);
			   }
		   }
		   
		   Collection<Entry<Product, Integer>> entries = chartDataMap.entrySet();
		   modelMap.addAttribute("entries", entries);
		   
		   Calendar calendar = Calendar.getInstance();
		   int currentYear = calendar.get(Calendar.YEAR);
		   int startYear = 1990;
		   
		   List<Integer> years = new LinkedList<Integer>();
		   for(int i=startYear;i<=currentYear;i++)
			   years.add(i);
		   
		   modelMap.addAttribute("years", years);
		   
		   return "chart";
	    }
	   
	   private int getMonth(Date date){
		   Calendar cal = Calendar.getInstance();
		   cal.setTime(date);
		   int month = cal.get(Calendar.MONTH);
		   
		   return month;
	   }
	   
	   private int getYear(Date date){
		   Calendar cal = Calendar.getInstance();
		   cal.setTime(date);
		   int year = cal.get(Calendar.YEAR);
		   
		   return year;
	   }
}
