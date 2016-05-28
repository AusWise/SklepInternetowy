package name.auswise.spring.webstore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import name.auswise.spring.webstore.model.User;

@Component
public class UserValidator implements Validator {
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	@Autowired
	private UserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object o, Errors errors) {
		User user = (User)o;
		
		ValidationUtils.rejectIfEmpty(errors, "Imie", "NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "Nazwisko", "NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "PESEL", "NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "Email", "NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "Ulica", "NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "NrBudynku", "NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "Miasto", "NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "KodPocztowy", "NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "login", "NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "haslo", "NotEmpty");
		
		if(errors.hasErrors())
			return;
		
		if (user.getLogin().length() < 6 || user.getLogin().length() > 32) {
            errors.rejectValue("login", "Size.user.login");
        }
		
        if (user.getHaslo().length() < 8 || user.getHaslo().length() > 32) {
            errors.rejectValue("haslo", "Size.user.password");
        }
        
        if(errors.hasErrors())
			return;
        
        if(!validateEmail(user.getEmail()))
        	errors.rejectValue("Email", "BadEmail");
        
//        if(!validatePesel(String.valueOf(user.getPESEL())))
//        	errors.rejectValue("PESEL", "BadPesel");
        	
        if(errors.hasErrors())
			return;
        
        
        if (userService.findByLogin(user.getLogin()) != null) {
            errors.rejectValue("login", "Duplicate.user.login");
        }
        
        if (userService.findByLogin(user.getLogin()) != null) {
            errors.rejectValue("PESEL", "Duplicate.user.pesel");
        }
        
        if (userService.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("Email", "Duplicate.user.Email");
        }
        
        if(errors.hasErrors())
			return;
        
        if (!user.getPasswordConfirm().equals(user.getHaslo())) {
            errors.rejectValue("passwordConfirm", "Diff.user.passwordConfirm");
        }
	}

	private boolean validateEmail(final String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher  matcher = pattern.matcher(email);
        return matcher.matches();
    }
	
	private boolean validatePesel(String pesel){
		PeselValidator peselValidator = new PeselValidator(pesel);
		return peselValidator.isValid();
	}
	
	
}
