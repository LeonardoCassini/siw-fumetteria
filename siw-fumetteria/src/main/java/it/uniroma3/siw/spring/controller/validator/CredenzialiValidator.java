package it.uniroma3.siw.spring.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.Credenziali;
import it.uniroma3.siw.spring.service.CredenzialiService;

@Component
public class CredenzialiValidator implements Validator{

	@Autowired
	private CredenzialiService credenzialiService;
	
	final Integer MAX_EMAIL_LENGTH = 30;
    final Integer MIN_EMAIL_LENGTH = 4;
    final Integer MAX_PASSWORD_LENGTH = 20;
    final Integer MIN_PASSWORD_LENGTH = 6;
    
	@Override
	public boolean supports(Class<?> clazz) {
		
		return Credenziali.class.equals(clazz);
	}

	@Override
	public void validate(Object o, Errors errors) {
		Credenziali credenziali = (Credenziali) o;
		String email = credenziali.getUsername().trim();
		String password = credenziali.getPassword().trim();
		
		if (email.isEmpty())
            errors.rejectValue("username", "required");
        else if (email.length() < MIN_EMAIL_LENGTH || email.length() > MAX_EMAIL_LENGTH)
            errors.rejectValue("username", "size");
        else if (this.credenzialiService.getCredentials(email) != null)
            errors.rejectValue("username", "duplicate");

        if (password.isEmpty())
            errors.rejectValue("password", "required");
        else if (password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH)
            errors.rejectValue("password", "size");
	}

}
