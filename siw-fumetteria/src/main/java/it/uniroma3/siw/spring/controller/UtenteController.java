package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.siw.spring.service.CredenzialiService;
import it.uniroma3.siw.spring.service.UtenteService;

@Controller
public class UtenteController 
{
	@Autowired
	private UtenteService utenteService;
	@Autowired
	private CredenzialiService credenzialiService;
	
	@RequestMapping(value="/cliente/{username}", method=RequestMethod.GET)
	public String MostraUtente(Model model)
	{
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username=userDetails.getUsername();
        model.addAttribute("credenziali", this.credenzialiService.getCredenzialiByUsername(username));
		return "/cliente";
	}
}
