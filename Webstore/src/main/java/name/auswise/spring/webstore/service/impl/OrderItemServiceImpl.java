package name.auswise.spring.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import name.auswise.spring.webstore.model.OrderItem;
import name.auswise.spring.webstore.model.repository.OrderItemRepository;
import name.auswise.spring.webstore.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Override
	public void save(OrderItem orderItem) {
		orderItemRepository.save(orderItem);
	}

	@Override
	public List<OrderItem> findAll() {
		return orderItemRepository.findAll();
	}

}
