package name.auswise.spring.webstore.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import name.auswise.spring.webstore.model.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
	ProductType findByNazwa(String Nazwa);
}
