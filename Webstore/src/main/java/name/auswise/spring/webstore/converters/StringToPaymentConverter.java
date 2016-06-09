package name.auswise.spring.webstore.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import name.auswise.spring.webstore.model.Payment;
import name.auswise.spring.webstore.service.PaymentService;

public class StringToPaymentConverter implements Converter<String, Payment> {

	@Autowired
	PaymentService paymentService;
	
	@Override
	public Payment convert(String nazwa) {
		return paymentService.findByNazwa(nazwa);
	}

}
