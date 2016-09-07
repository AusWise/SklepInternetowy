package name.auswise.spring.webstore.service;

import java.util.List;

import name.auswise.spring.webstore.model.Product;

public interface ProductService {
	Product findOne(Long id);
	Product findByNazwa(String nazwa);
	List<Product> findAll();
	void delete(Long id);
	void save(Product product);
}
