package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.controller.validator.CredenzialiValidator;
import it.uniroma3.siw.spring.controller.validator.UtenteValidator;
import it.uniroma3.siw.spring.model.Carrello;
import it.uniroma3.siw.spring.model.Credenziali;
import it.uniroma3.siw.spring.model.Utente;
import it.uniroma3.siw.spring.service.CredenzialiService;

@Controller
public class AuthController 
{
	@Autowired
	private CredenzialiService credentialsService;
	@Autowired
	private UtenteValidator utenteValidator;
	@Autowired
	private CredenzialiValidator credenzialiValidator;


	@RequestMapping(value = "/registrazione", method = RequestMethod.GET)
	public String formRegistrazione (Model model) {
		model.addAttribute("utente", new Utente());
		model.addAttribute("credenziali", new Credenziali());
		model.addAttribute("carrello", new Carrello());
		return "/registrazione";
	}


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) 
	{
		return "/login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET) 
	public String logout(Model model) 
	{
		return "/homePage";
	}

	@RequestMapping(value = "/default", method = RequestMethod.GET)
	public String defaultAfterLoginAdmin(Model model) 
	{

		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Credenziali credentials = credentialsService.getCredentials(userDetails.getUsername());
		if (credentials.getRole().equals(Credenziali.ADMIN_ROLE)) 
		{
			return "/admin/adminHome.html";
		}
		return "/homePage";
	}

//	@RequestMapping(value = "/default", method = RequestMethod.GET)
//	public String defaultAfterLoginCliente(Model model) 
//	{
//
//		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		Credenziali credentials = credentialsService.getCredentials(userDetails.getUsername());
//		if (credentials.getRole().equals(Credenziali.DEFAULT_ROLE)) 
//		{
//			return "/cliente";
//		}
//		return "/homePage";
//	}

	@RequestMapping(value = { "/registrazione" }, method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("utente") Utente utente, 
			BindingResult utenteBr, 
			@ModelAttribute("credenziali") Credenziali credenziali, 
			BindingResult credenzialiBr,
			@ModelAttribute("carrello") Carrello carrello, 
			Model model) 
	{


		this.utenteValidator.validate(utente, utenteBr);
		this.credenzialiValidator.validate(credenziali, credenzialiBr);

		if(!utenteBr.hasErrors() && ! credenzialiBr.hasErrors()) 
		{
			utente.setEmail(credenziali.getUsername());
			credenziali.setCliente(utente);
			credentialsService.saveCredentials(credenziali);
			return "redirect:/homePage";
		}
		return "/registrazione";
	}

}
