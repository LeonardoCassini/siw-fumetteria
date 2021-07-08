package it.uniroma3.siw.spring.controller.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import it.uniroma3.siw.spring.model.Autore;
import it.uniroma3.siw.spring.service.AutoreService;

@Component
public class AutoreValidator implements Validator
{
	@Autowired
	private AutoreService autoreService;
	
	private static final Logger logger = LoggerFactory.getLogger(AutoreValidator.class);
	
	@Override
	public void validate(Object o, Errors errors)
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nome","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"cognome","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"struttura","required");
		
		if(!errors.hasErrors())
		{
			logger.debug("confermato: valori non nulli");
		}
	}

	
	@Override
	public boolean supports(Class<?> aClass) 
	{
		return Autore.class.equals(aClass);
	}
}