package name.auswise.spring.webstore.service;

import java.util.List;

import name.auswise.spring.webstore.model.ProductType;

public interface ProductTypeService {

	ProductType findByNazwa(String typProduktu);

	List<ProductType> findAll();

}
