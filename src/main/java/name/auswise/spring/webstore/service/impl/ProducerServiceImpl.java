package name.auswise.spring.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import name.auswise.spring.webstore.model.Producer;
import name.auswise.spring.webstore.service.ProducerService;
import name.auswise.spring.webstore.model.repository.ProducerRepository;

@Service
public class ProducerServiceImpl implements ProducerService{

	@Autowired
	ProducerRepository producerRepository;
	
	@Override
	public Producer findByNazwa(String producent) {
		return producerRepository.findByNazwa(producent);
	}

	@Override
	public List<Producer> findAll() {
		return producerRepository.findAll();
	}

}
