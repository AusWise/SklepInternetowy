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
	public void create(long id) {
		carts.put(id, new Cart());
		System.out.println("Cart " + id + " created");
	}

	@Override
	public Cart get(long id) {
		System.out.println("Get " + id + " cart");
		return carts.get(id);
	}
}
