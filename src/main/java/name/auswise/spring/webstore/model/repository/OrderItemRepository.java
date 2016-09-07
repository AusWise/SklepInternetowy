package name.auswise.spring.webstore.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import name.auswise.spring.webstore.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
