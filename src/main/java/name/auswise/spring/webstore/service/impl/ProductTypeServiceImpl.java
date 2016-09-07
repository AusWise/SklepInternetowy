package name.auswise.spring.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import name.auswise.spring.webstore.model.ProductType;
import name.auswise.spring.webstore.service.ProductTypeService;
import name.auswise.spring.webstore.model.repository.ProductTypeRepository;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	ProductTypeRepository productTypeRepository;
	
	@Override
	public ProductType findByNazwa(String typProduktu) {
		return productTypeRepository.findByNazwa(typProduktu);
	}

	@Override
	public List<ProductType> findAll() {
		return productTypeRepository.findAll();
	}
}
