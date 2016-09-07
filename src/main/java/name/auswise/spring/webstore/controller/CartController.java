package name.auswise.spring.webstore.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import name.auswise.spring.webstore.model.Cart;
import name.auswise.spring.webstore.model.CartItem;
import name.auswise.spring.webstore.model.Delivery;
import name.auswise.spring.webstore.model.Order;
import name.auswise.spring.webstore.model.OrderItem;
import name.auswise.spring.webstore.model.Payment;
import name.auswise.spring.webstore.model.Product;
import name.auswise.spring.webstore.model.User;
import name.auswise.spring.webstore.service.CartService;
import name.auswise.spring.webstore.service.DeliveryService;
import name.auswise.spring.webstore.service.OrderItemService;
import name.auswise.spring.webstore.service.OrderService;
import name.auswise.spring.webstore.service.PaymentService;
import name.auswise.spring.webstore.service.ProductService;
import name.auswise.spring.webstore.service.UserService;

@Controller
public class CartController {
	
	@Autowired
	ProductService productService;

	@Autowired
	PaymentService paymentService;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderItemService orderItemService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	DeliveryService deliveryService;
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String cart(Model model){
		Cart cart = cartService.getCurrentUserCart();
		model.addAttribute("cart", cart);
		
		return "cart";
	}
	   
	@RequestMapping(value = "/cart/add", method = RequestMethod.GET)
	public String addProduct(Long id, Model model){
		if(id==null)
			return "redirect:/cart";
		
		Cart cart = cartService.getCurrentUserCart();
		Product product = productService.findOne(id);
		if(product == null)
			return "redirect:/cart";
		
		for(CartItem cartItem: cart.getCartItems())
			if(cartItem.getProduct().equals(product))
				return "redirect:/cart";
		
		cart.addProduct(product, 1);
		
		return "redirect:/cart";
	}
	   
	@RequestMapping(value = "/cart/edit", method = RequestMethod.GET)
	public String editCartItem(Long id, Model model){
		if(id==null)
			return "redirect:/cart";
		
		
		Cart cart = cartService.getCurrentUserCart();
		
		CartItem cartItem = cart.getCartItem(id);
			
		if(cartItem == null)
			return "redirect:/cart";
	
		model.addAttribute("cartItem", cartItem);
		
		return "editCartItem";
	}
	
	@RequestMapping(value = "/cart/edit", method = RequestMethod.POST)
	public String editCartItem(@ModelAttribute("cartItem") CartItem current, BindingResult bindingResult, Model model){
		Cart cart = cartService.getCurrentUserCart();
		
		Iterable<CartItem> cartItems = cart.getCartItems();
		for(CartItem cartItem: cartItems)
			if(cartItem.equals(current))
				cartItem.setNumber(current.getNumber());
		
		return "redirect:/cart";
	}

	@RequestMapping(value = "/cart/remove", method = RequestMethod.GET)
	public String removeProduct(Long id, Model model){
		if(id==null)
			return "redirect:/cart";
		
		Cart cart = cartService.getCurrentUserCart();  
		try{
			cart.removeProduct(id);
		}
		catch(RuntimeException e){
			return "redirect:/cart";
		}
		   
		return "redirect:/cart";
	}  
	   
	@RequestMapping(value = "/buy", method = RequestMethod.GET)
	public String buy(Model model){
		Order order = new Order();
		model.addAttribute("order", order);
		
		List<Delivery> deliveries = deliveryService.findAll();
		model.addAttribute("deliveries", deliveries);
		
		List<Payment> payments = paymentService.findAll();
		model.addAttribute("payments", payments);
		
		return "buy";
	}
	   
	@RequestMapping(value = "/buy", method = RequestMethod.POST)
	public String buy(@ModelAttribute("order") Order order, BindingResult bindingResult, Model model){
		User current = getCurrentUser();
		order.setUser(current);
		
		Cart cart = cartService.getCurrentUserCart();
		
		if(cart.getCartItems().isEmpty())
			return "redirect:/cart";
		
		order.setOrderItems(cart);
		order.setData(new Date());
		
		orderService.save(order);
		
		for(OrderItem orderItem: order.getOrderItems())
			orderItemService.save(orderItem);
		
		return "redirect:/";
	}
	   
	private User getCurrentUser(){
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		String login = authentication.getName();
		User current = userService.findByLogin(login);
		return current;
	}
}
