package name.auswise.spring.webstore.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import name.auswise.spring.webstore.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByLogin(String login);
	User findByEmail(String email);
}
