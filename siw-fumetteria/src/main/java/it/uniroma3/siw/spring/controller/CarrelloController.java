package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uniroma3.siw.spring.service.OrdineService;
import it.uniroma3.siw.spring.service.UtenteService;

@Controller
public class CarrelloController 
{
	@Autowired
	private OrdineService ordineService;
	@Autowired
	protected UtenteService utenteService;

	@RequestMapping(value="/carrello",method=RequestMethod.GET)
	public String mostraCarrello(Model model)
	{
		model.addAttribute("volumeCarrello", this.ordineService.carrello());
		return"/carrello";
	}
}
