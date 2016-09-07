package name.auswise.spring.webstore.service;

import java.util.List;

import name.auswise.spring.webstore.model.Producer;

public interface ProducerService {

	Producer findByNazwa(String producent);

	List<Producer> findAll();

}
