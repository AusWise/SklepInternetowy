package name.auswise.spring.webstore.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import name.auswise.spring.webstore.model.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

}
