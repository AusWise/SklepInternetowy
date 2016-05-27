package name.auswise.spring.webstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import name.auswise.spring.webstore.model.Role;
import name.auswise.spring.webstore.model.User;
import name.auswise.spring.webstore.model.repository.RoleRepository;
import name.auswise.spring.webstore.model.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public void save(User user) {
		Role ROLE_USER = roleRepository.findByNazwa("USER");
		user.setRola(ROLE_USER);
		userRepository.save(user);
	}

	@Override
	public User findByLogin(String login) {
		return userRepository.findByLogin(login);
	}

}
