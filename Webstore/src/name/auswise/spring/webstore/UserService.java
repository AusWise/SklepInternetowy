package name.auswise.spring.webstore;

import name.auswise.spring.webstore.model.User;

	
public interface UserService {
	void save(User user);
	User findByLogin(String login);
}
