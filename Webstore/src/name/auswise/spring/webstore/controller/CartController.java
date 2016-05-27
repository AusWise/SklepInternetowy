package name.auswise.spring.webstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestParam;

import name.auswise.spring.webstore.model.Cart;
import name.auswise.spring.webstore.model.CartItem;
import name.auswise.spring.webstore.model.Delivery;
import name.auswise.spring.webstore.model.Order;
import name.auswise.spring.webstore.model.OrderItem;
import name.auswise.spring.webstore.model.Payment;
import name.auswise.spring.webstore.model.Product;
import name.auswise.spring.webstore.model.User;
import name.auswise.spring.webstore.model.repository.CartRepository;
import name.auswise.spring.webstore.model.repository.CartRepositoryImpl;
import name.auswise.spring.webstore.model.repository.DeliveryRepository;
import name.auswise.spring.webstore.model.repository.OrderItemRepository;
import name.auswise.spring.webstore.model.repository.OrderRepository;
import name.auswise.spring.webstore.model.repository.PaymentRepository;
import name.auswise.spring.webstore.model.repository.ProductRepository;
import name.auswise.spring.webstore.model.repository.UserRepository;

@Controller
public class CartController {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	DeliveryRepository deliveryRepository;
	
	@Autowired
	PaymentRepository paymentRepository;
	
	CartRepository cartRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public CartController(){
		cartRepository = new CartRepositoryImpl();
	}
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	   public String cart(Model model){
		   Cart cart = getCurrentUserCart();
		   model.addAttribute("cart", cart);
		   
		   return "cart";
	   }
	   
	   @RequestMapping(value = "/cart/add", method = RequestMethod.GET)
	   public String addProduct(Long id, Model model){
		   Cart cart = getCurrentUserCart();
		   Product product = productRepository.findOne(id);
		   cart.addProduct(product, 1);
		
		   return "redirect:/cart";
	   }
	   
	   @RequestMapping(value = "/cart/edit", method = RequestMethod.GET)
	   public String editCartItem(Long id, Model model){
		   Cart cart = getCurrentUserCart();
		   CartItem cartItem = cart.getCartItem(id);
		   model.addAttribute("cartItem", cartItem);
		
		   return "editCartItem";
	   }
	   
	   @RequestMapping(value = "/cart/edit", method = RequestMethod.POST)
	   public String editCartItem(@ModelAttribute("cartItem") CartItem cartItem, BindingResult bindingResult, Model model, HttpServletRequest request){
		   int id = Integer.parseInt(request.getParameter("id"));
		   Cart cart = getCurrentUserCart();
		   
		   cart.setNumber(id, cartItem.getNumber());
		   
		   return "redirect:/cart";
	   }
	   
	   @RequestMapping(value = "/cart/clear", method = RequestMethod.GET)
	   public String clearCart(Model model){
		   Cart cart = getCurrentUserCart();
		   
		   cart.clear();
		   return "redirect:/cart";
	   }
	   
	   @RequestMapping(value = "/cart/remove", method = RequestMethod.GET)
	   public String removeProduct(Long id, Model model){
		   Cart cart = getCurrentUserCart();
		   cart.removeProduct(id);
		   return "redirect:/cart";
	   }
	   
	   private Cart getCurrentUserCart(){
		   User current = getCurrentUser();
		   long userId = current.getID();
		   Cart cart = cartRepository.get(userId);
		   if(cart == null){
			   cartRepository.create(userId);
			   cart = cartRepository.get(userId);
		   }
		   
		   return cart;
	   }
	   
	   @RequestMapping(value = "/buy", method = RequestMethod.GET)
	   public String buy(Model model){
		   
		   Order order = new Order();
		   
		   model.addAttribute("order", order);
		   
		   List<Delivery> deliveries = deliveryRepository.findAll();
		   model.addAttribute("deliveries", deliveries);
		   
		   List<Payment> payments = paymentRepository.findAll();
		   model.addAttribute("payments", payments);
		   
		   return "buy";
	   }
	   
	   @RequestMapping(value = "/buy", method = RequestMethod.POST)
	   public String buy(
			   @RequestParam Long delivery, 
			   @RequestParam Long payment, 
			   @ModelAttribute("order") Order order, 
			   BindingResult bindingResult,
			   Model model){
		   Delivery wysylka = deliveryRepository.findOne(delivery);
		   order.setDelivery(wysylka);
		   
		   Payment platnosc = paymentRepository.findOne(payment);
		   order.setPayment(platnosc);
		   
		   User current = getCurrentUser();
		   order.setUser(current);
		   
		   Cart cart = getCurrentUserCart();
		   order.setOrderItems(cart);
		   
//		   System.out.println(order.getOrderItems().size());
		   
		   orderRepository.save(order);
		   
		   for(OrderItem orderItem: order.getOrderItems())
			   orderItemRepository.save(orderItem);
		   
		   return "redirect:/";
	   }
	   
	   private User getCurrentUser(){
		   SecurityContext context = SecurityContextHolder.getContext();
		   Authentication authentication = context.getAuthentication();
		   String login = authentication.getName();
		   User current = userRepository.findByLogin(login);
		   
		   return current;
	   }
}
