package name.auswise.spring.webstore.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import name.auswise.spring.webstore.model.Delivery;
import name.auswise.spring.webstore.model.repository.DeliveryRepository;
import name.auswise.spring.webstore.service.DeliveryService;

@Service
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	DeliveryRepository deliveryRepository;
	
	@Override
	public List<Delivery> findAll() {
		return deliveryRepository.findAll();
	}
	
	@Override
	public Delivery getCheapestDelivery(){
		List<Delivery> deliveries = this.findAll();
		
		System.out.println(deliveries.isEmpty());
		
		return Collections.min(deliveries, new Comparator<Delivery>(){

			@Override
			public int compare(Delivery delivery1, Delivery delivery2) {
				return Double.compare(delivery1.getCena(), delivery2.getCena());
			}});
	}

	@Override
	public Delivery findOne(Long delivery) {
		return deliveryRepository.findOne(delivery);
	}

	@Override
	public Delivery findByNazwa(String nazwa) {
		return deliveryRepository.findByNazwa(nazwa);
	}
}
