package name.auswise.spring.webstore.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import name.auswise.spring.webstore.model.Delivery;
import name.auswise.spring.webstore.service.DeliveryService;

public class StringToDeliveryConverter implements Converter<String, Delivery> {

	@Autowired
	DeliveryService deliveryService;
	
	@Override
	public Delivery convert(String nazwa) {
		return deliveryService.findByNazwa(nazwa);
	}
	
}
