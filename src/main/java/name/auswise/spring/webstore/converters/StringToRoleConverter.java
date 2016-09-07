package name.auswise.spring.webstore.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import name.auswise.spring.webstore.model.repository.RoleRepository;
import name.auswise.spring.webstore.model.Role;

public class StringToRoleConverter implements Converter<String, Role>{

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role convert(String nazwa) {
		return roleRepository.findByNazwa(nazwa);
	}
}
