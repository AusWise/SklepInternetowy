package name.auswise.spring.webstore.service;

import java.util.List;

import name.auswise.spring.webstore.model.Delivery;

public interface DeliveryService {
	List<Delivery> findAll();
	Delivery getCheapestDelivery();
	Delivery findOne(Long delivery);
	Delivery findByNazwa(String nazwa);
}
