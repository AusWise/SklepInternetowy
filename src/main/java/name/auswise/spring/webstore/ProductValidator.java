package name.auswise.spring.webstore;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import name.auswise.spring.webstore.model.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Product.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product)target;
	}
}
