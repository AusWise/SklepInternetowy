package name.auswise.spring.webstore.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import name.auswise.spring.webstore.model.Role;

public interface RoleRepository extends  JpaRepository<Role, Long>{
	Role findByNazwa(String nazwa);
}
