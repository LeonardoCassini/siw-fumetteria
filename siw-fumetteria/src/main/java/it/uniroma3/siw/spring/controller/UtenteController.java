package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uniroma3.siw.spring.controller.validator.ModificaCredenzialiValidator;
import it.uniroma3.siw.spring.model.Credenziali;
import it.uniroma3.siw.spring.service.CredenzialiService;

@Controller
public class UtenteController 
{
	@Autowired
	private CredenzialiService credenzialiService;
	@Autowired
	private ModificaCredenzialiValidator modificaCredenzialiValidator;
	@Autowired
    protected PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/cliente/{username}", method=RequestMethod.GET)
	public String MostraUtente(Model model)
	{
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username=userDetails.getUsername();
        model.addAttribute("credenziali", this.credenzialiService.getCredenzialiByUsername(username));
		return "/cliente";
	}
	

	@RequestMapping(value="/updCliente/{id}", method=RequestMethod.GET)
	public String ModificaUtente(@PathVariable("id")Long id, Model model)
	{
        model.addAttribute("credenziali", this.credenzialiService.getCredenzialiById(id));
		return "/updCliente";
	}
	
	@RequestMapping(value="/updCliente/{id}", method=RequestMethod.POST)
	public String ModificaUtente(@ModelAttribute("credenziali")Credenziali credenziali,
			Model model,
			BindingResult utenteBr,
			BindingResult credenzialiBr)
	{
		
		this.modificaCredenzialiValidator.validate(credenziali, credenzialiBr);
		
		if(!credenzialiBr.hasErrors()) {
			credenziali.setPassword(credenziali.getUtente().getPassword());
			this.credenzialiService.saveCredentials(credenziali);
			
			return "redirect:/homePage";
		}
		return "/updCliente";
	}
}
