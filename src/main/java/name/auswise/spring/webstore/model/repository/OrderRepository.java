package name.auswise.spring.webstore.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import name.auswise.spring.webstore.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
}
