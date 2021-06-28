package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.service.GenereService;

@Controller
public class GenereController 
{
	@Autowired
	private GenereService genereService;
	
	@RequestMapping(value="/generi",method=RequestMethod.GET)
	public String showGeneri(Model model)
	{
		model.addAttribute("generi",this.genereService.getAllGeneri());
		return"generi.html";
	}
	
	@RequestMapping(value="/generi/{id}", method=RequestMethod.GET)
	public String showOpere(@PathVariable("id") Long id, Model model)
	{
		model.addAttribute("opereGenere",this.genereService.getGenere(id));
		return "opereGenere.html";
	}
}
