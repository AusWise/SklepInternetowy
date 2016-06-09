package name.auswise.spring.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import name.auswise.spring.webstore.model.Role;
import name.auswise.spring.webstore.model.User;
import name.auswise.spring.webstore.model.repository.RoleRepository;
import name.auswise.spring.webstore.model.repository.UserRepository;
import name.auswise.spring.webstore.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public void save(User user) {
		if(user.getRola() == null){
			Role ROLE_USER = roleRepository.findByNazwa("USER");
			user.setRola(ROLE_USER);
		}
		
		userRepository.save(user);
	}

	@Override
	public User findByLogin(String login) {
		return userRepository.findByLogin(login);
	}
	
	@Override 
	public User findByEmail(String email){
		return userRepository.findByEmail(email);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findOne(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		userRepository.delete(id);
	}
}
