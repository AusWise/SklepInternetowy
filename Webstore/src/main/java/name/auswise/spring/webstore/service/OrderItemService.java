package name.auswise.spring.webstore.service;

import java.util.List;

import name.auswise.spring.webstore.model.OrderItem;

public interface OrderItemService {
	void save(OrderItem orderItem);

	List<OrderItem> findAll();
	
}
