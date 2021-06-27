package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import it.uniroma3.siw.spring.model.Autore;
import it.uniroma3.siw.spring.service.OperaService;

@RestController
public class OperaController 
{
	@Autowired
	private OperaService operaService;
	
//	@RequestMapping(value="/autore/{id}", method=RequestMethod.GET)
//	public String showOpere(Autore autore, Model model)
//	{
//		model.addAttribute("opereAutore",this.operaService.getOpereAutore(autore));
//		return "opereAutore.html";
//	}
}
