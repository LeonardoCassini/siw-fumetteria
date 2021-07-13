package it.uniroma3.siw.spring.controller.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.Utente;

@Component
public class ModificaUtenteValidator implements Validator{
	
	private static final Logger logger = LoggerFactory.getLogger(ModificaOperaValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Utente.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) 
	{

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataNascita", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "indirizzo", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","required");
		
		if(!errors.hasErrors()) 
		{
			logger.debug("confermato: valori non nulli");
		}
		
	}
}
