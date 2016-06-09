package name.auswise.spring.webstore.service;

import java.util.List;

import name.auswise.spring.webstore.model.User;

public interface UserService {
	void save(User user);
	User findByLogin(String login);
	User findByEmail(String email);
	List<User> findAll();
	User findOne(Long id);
	void delete(Long id);
}
