package name.auswise.spring.webstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import name.auswise.spring.webstore.model.User;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object o, Errors errors) {
		User user = (User)o;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "NotEmpty");
//        if (user.getLogin().length() < 6 || user.getLogin().length() > 32) {
//            errors.rejectValue("login", "Size.user.login");
//        }
		
//        if (userService.findByLogin(user.getLogin()) != null) {
//            errors.rejectValue("username", "Duplicate.userForm.username");
//        }

//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
//        if (user.getHaslo().length() < 8 || user.getHaslo().length() > 32) {
//            errors.rejectValue("password", "Size.userForm.password");
//        }

//        if (!user.getPasswordConfirm().equals(user.getHaslo())) {
//            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
//        }
	}

	
	
}
