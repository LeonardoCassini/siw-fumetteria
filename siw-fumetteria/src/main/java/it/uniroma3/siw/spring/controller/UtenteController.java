package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.siw.spring.service.CredenzialiService;
import it.uniroma3.siw.spring.service.UtenteService;

@RestController
public class UtenteController 
{
	@Autowired
	private UtenteService clienteService;
	@Autowired
	private CredenzialiService credenzialiService;
	
	@GetMapping(value="/cliente/{username}")
	public String MostraUtente(@PathVariable("username") String username, Model model)
	{
		model.addAttribute("credenziali",this.credenzialiService.getCredenzialiByUsername(username));
		return "/cliente";
	}
}
