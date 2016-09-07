package name.auswise.spring.webstore.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class Cart {
	private Set<CartItem> cartItems;
	
	public Cart(){
		cartItems = new HashSet<CartItem>();
	}
	
	public void addProduct(Product product, int number){
		cartItems.add(new CartItem(product,number));
	}
	
	public Product getProduct(long id){
		CartItem cartItem = getCartItem(id);
		
		if(cartItem != null)
			return cartItem.getProduct();
		
		return null;
	}
	
	public Integer getNumber(long id){
		CartItem cartItem = getCartItem(id);
		
		if(cartItem != null)
			return cartItem.getNumber();
		
		return null;
	}
	
	public void setNumber(long id, int number){
		CartItem cartItem = getCartItem(id);
		
		if(cartItem == null)
			throw new RuntimeException();
		
		cartItem.setNumber(number);
	}
	
	public void removeProduct(long id){
		CartItem cartItem = getCartItem(id);
		
		if(cartItem == null)
			throw new RuntimeException();
		
		cartItems.remove(cartItem);
	}
	
	public void clear(){
		cartItems.clear();
	}
	
	public Collection<CartItem> getCartItems(){
		return cartItems;
	}
	
	public CartItem getCartItem(long id){
		for(CartItem cartItem: cartItems)
			if(cartItem.getProduct().getID() == id)
				return cartItem;
		
		return null;
	}
	
	public double getTotal(){
		double subTotal = 0;
		for(CartItem cartItem: getCartItems())
			subTotal += cartItem.getTotal();
		
		return subTotal;
	}

	

	
	
	
	
	
}
