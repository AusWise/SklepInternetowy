package name.auswise.spring.webstore.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import name.auswise.spring.webstore.model.Producer;

public interface ProducerRepository extends JpaRepository<Producer, Long> {
	Producer findByNazwa(String Nazwa);
}
