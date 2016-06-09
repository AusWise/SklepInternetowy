package name.auswise.spring.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import name.auswise.spring.webstore.model.Payment;
import name.auswise.spring.webstore.model.repository.PaymentRepository;
import name.auswise.spring.webstore.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository paymentRepository;
	
	@Override
	public List<Payment> findAll() {
		return paymentRepository.findAll();
	}

	@Override
	public Payment findOne(Long payment) {
		return paymentRepository.findOne(payment);
	}

	@Override
	public Payment findByNazwa(String nazwa) {
		return paymentRepository.findByNazwa(nazwa);
	}
}
