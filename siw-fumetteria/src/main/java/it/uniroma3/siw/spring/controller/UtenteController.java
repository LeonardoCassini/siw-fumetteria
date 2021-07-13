package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.siw.spring.controller.validator.CredenzialiValidator;
import it.uniroma3.siw.spring.controller.validator.ModificaCredenzialiValidator;
import it.uniroma3.siw.spring.controller.validator.ModificaUtenteValidator;
import it.uniroma3.siw.spring.controller.validator.UtenteValidator;
import it.uniroma3.siw.spring.model.Credenziali;
import it.uniroma3.siw.spring.model.Utente;
import it.uniroma3.siw.spring.service.CredenzialiService;
import it.uniroma3.siw.spring.service.UtenteService;

@Controller
public class UtenteController 
{
	@Autowired
	private UtenteService utenteService;
	@Autowired
	private CredenzialiValidator credenzialiValidator;
	@Autowired
	private UtenteValidator utenteValidator;
	@Autowired
	private CredenzialiService credenzialiService;
	@Autowired
	private ModificaUtenteValidator modificaUtenteValidator;
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
        model.addAttribute("utente", this.credenzialiService.getCredenzialiById(this.credenzialiService.getCredenzialiById(id).getUtente().getId()));
		return "/updCliente";
	}
	
	@RequestMapping(value="/updCliente/{id}", method=RequestMethod.POST)
	public String ModificaUtente(@ModelAttribute("credenziali")Credenziali credenziali,
			Model model,
			@ModelAttribute("utente")Utente cliente,
			BindingResult utenteBr,
			BindingResult credenzialiBr)
	{
		
		this.modificaCredenzialiValidator.validate(credenziali, credenzialiBr);
		if(!credenzialiBr.hasErrors()) 
		{
			credenziali.setPassword(credenziali.getUtente().getPassword());
			this.credenzialiService.saveCredentials(credenziali);
			
			return "redirect:/homePage";
		}
		return "/updCliente";
	}
}
