package name.auswise.spring.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import name.auswise.spring.webstore.model.Order;
import name.auswise.spring.webstore.model.repository.OrderRepository;
import name.auswise.spring.webstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public void save(Order order) {
		orderRepository.save(order);
	}
}
