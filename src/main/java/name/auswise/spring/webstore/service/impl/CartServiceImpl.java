package name.auswise.spring.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import name.auswise.spring.webstore.model.Cart;
import name.auswise.spring.webstore.model.User;
import name.auswise.spring.webstore.model.repository.CartRepository;
import name.auswise.spring.webstore.model.repository.CartRepositoryImpl;
import name.auswise.spring.webstore.model.repository.UserRepository;
import name.auswise.spring.webstore.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	UserRepository userRepository;
	
	CartRepository cartRepository;
	
	public CartServiceImpl() {
		cartRepository = new CartRepositoryImpl();
	}
	
	@Override
	public Cart getCurrentUserCart() {		
		User current = getCurrentUser();
		long userId = current.getID();
		
		Cart cart = findOne(userId);
		if(cart == null){
			save(userId, new Cart());
			cart = findOne(userId);
		}
		
		return cart;
	}
	
	private User getCurrentUser(){
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		String login = authentication.getName();
		
		User current = userRepository.findByLogin(login);
		
		return current;
	}

	@Override
	public Cart findOne(long userId) {
		return cartRepository.findOne(userId);
	}

	@Override
	public void save(long userId, Cart cart) {
		cartRepository.save(userId, cart);
	}
}
