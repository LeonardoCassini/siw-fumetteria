package it.uniroma3.siw.spring.controller.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.Credenziali;

@Component
public class ModificaCredenzialiValidator implements Validator{

	private static final Logger logger = LoggerFactory.getLogger(ModificaOperaValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {

		return Credenziali.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error");

		if(!errors.hasErrors()) {
			logger.debug("Confermato: valori non nulli");	
		}

	}

}
