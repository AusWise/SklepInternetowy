package name.auswise.spring.webstore.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import name.auswise.spring.webstore.model.Product;
import name.auswise.spring.webstore.service.ProductService;

public class StringToProductConverter implements Converter<String, Product> {

	@Autowired
	ProductService productService;
	
	@Override
	public Product convert(String nazwa) {
		return productService.findByNazwa(nazwa);
	}

}
