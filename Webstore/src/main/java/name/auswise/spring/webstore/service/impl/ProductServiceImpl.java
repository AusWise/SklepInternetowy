package name.auswise.spring.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import name.auswise.spring.webstore.model.Product;
import name.auswise.spring.webstore.model.repository.ProductRepository;
import name.auswise.spring.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product findOne(Long id) {
		return productRepository.findOne(id);
	}

	@Override
	public Product findByNazwa(String nazwa) {
		return productRepository.findByNazwa(nazwa);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		productRepository.delete(id);
	}

	@Override
	public void save(Product product) {
		productRepository.save(product);
	}
}
