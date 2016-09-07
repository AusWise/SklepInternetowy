package name.auswise.spring.webstore.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import name.auswise.spring.webstore.model.ProductType;
import name.auswise.spring.webstore.service.ProductTypeService;

public class StringToProductTypeConverter implements Converter<String, ProductType> {

	@Autowired
	ProductTypeService productTypeService;
	
	@Override
	public ProductType convert(String typProduktu) {
		return productTypeService.findByNazwa(typProduktu);
	}

}
