package it.uniroma3.siw.spring.controller.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.Volume;
import it.uniroma3.siw.spring.service.VolumeService;

@Component
public class VolumeValidator implements Validator
{
	@Autowired
	private VolumeService volumeService;
	
	private static final Logger logger = LoggerFactory.getLogger(VolumeValidator.class);
	
	@Override
	public void validate(Object o, Errors errors)
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"isbn","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"titolo","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"numVolume","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"pagine","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"sinossi","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"prezzo","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"copertina","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"copie","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"pubblicazione","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"ristampa","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"opera","required");
		
		
		if(!errors.hasErrors())
		{
			logger.debug("confermato: valori non nulli");
			if(this.volumeService.duplicato((Volume)o))
			{
				logger.debug("e' un duplicato");
				errors.reject("duplicato");
			}
		}
	}
	
	@Override
	public boolean supports(Class<?> aClass) 
	{
		return Volume.class.equals(aClass);
	}
	
}
