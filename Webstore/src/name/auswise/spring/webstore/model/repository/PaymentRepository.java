package name.auswise.spring.webstore.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import name.auswise.spring.webstore.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
