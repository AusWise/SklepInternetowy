package name.auswise.spring.webstore.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import name.auswise.spring.webstore.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
