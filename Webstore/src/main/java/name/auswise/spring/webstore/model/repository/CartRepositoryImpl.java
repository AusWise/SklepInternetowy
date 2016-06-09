package name.auswise.spring.webstore.model.repository;

import java.util.HashMap;
import java.util.Map;

import name.auswise.spring.webstore.model.Cart;

public class CartRepositoryImpl implements CartRepository {

	Map<Long, Cart> carts;
	
	public CartRepositoryImpl(){
		carts = new HashMap<Long, Cart>();
	}
	
	@Override
	public void save(long id, Cart cart) {
		carts.put(id, cart);
		System.out.println("Cart " + id + " created");
	}

	@Override
	public Cart findOne(long id) {
		System.out.println("Get " + id + " cart");
		return carts.get(id);
	}
}
