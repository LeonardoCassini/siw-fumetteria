package it.uniroma3.siw.spring.controller.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import it.uniroma3.siw.spring.model.Opera;

@Component
public class ModificaOperaValidator implements Validator
{	
	private static final Logger logger = LoggerFactory.getLogger(ModificaOperaValidator.class);
	
	@Override
	public void validate(Object o, Errors errors)
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nome","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"genere","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"sinossi","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"target","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"stato","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"struttura","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nazionalita","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"immagine","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"autore","required");
		
		if(!errors.hasErrors())
		{
			logger.debug("confermato: valori non nulli");
		}
	}
	
	@Override
	public boolean supports(Class<?> aClass) 
	{
		return Opera.class.equals(aClass);
	}
}
