package name.auswise.spring.webstore.service;

import java.util.List;

import name.auswise.spring.webstore.model.Payment;

public interface PaymentService {
	List<Payment> findAll();
	Payment findOne(Long payment);
	Payment findByNazwa(String nazwa);
}
