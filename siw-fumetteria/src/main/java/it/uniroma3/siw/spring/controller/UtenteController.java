package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.service.UtenteService;

@Controller
public class UtenteController 
{
	@Autowired
	private UtenteService clienteService;
	
//	@RequestMapping(value="/login/{username}",method=RequestMethod.GET)
//	public String MostraUtente(@PathVariable("username") String username,Model model)
//	{
//		model.addAttribute("utente",this.clienteService.getCliente(id));
//		return "/cliente";
//	}
}
