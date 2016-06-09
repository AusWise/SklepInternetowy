package name.auswise.spring.webstore;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import name.auswise.spring.webstore.model.User;

@Component
public class RegistrationValidator extends UserValidator {

	@Override
	public void validate(Object o, Errors errors) {
		super.validate(o, errors);
		
		User user = (User)o;
		
		if(errors.hasErrors())
			return;
		
		if (!user.getHaslo().equals(user.getPasswordConfirm())) {
            errors.rejectValue("passwordConfirm", "Diff.user.passwordconfirm");
        }
	}
	
}
