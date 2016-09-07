package name.auswise.spring.webstore.model.repository;

import name.auswise.spring.webstore.model.Cart;

public interface CartRepository {
	Cart findOne(long userId);
	void save(long userId, Cart cart);
}
