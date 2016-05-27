package name.auswise.spring.webstore.model.repository;

import name.auswise.spring.webstore.model.Cart;

public interface CartRepository {
	void create(long id);
	Cart get(long id);
}
