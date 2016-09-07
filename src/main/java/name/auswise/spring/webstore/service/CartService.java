package name.auswise.spring.webstore.service;

import name.auswise.spring.webstore.model.Cart;

public interface CartService {
	Cart getCurrentUserCart();
	Cart findOne(long userId);
	void save(long userId, Cart cart);
}
