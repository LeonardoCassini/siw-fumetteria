package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import it.uniroma3.siw.spring.model.Autore;
//import org.springframework.web.bind.annotation.RestController;
import it.uniroma3.siw.spring.service.AutoreService;

@Controller
public class AutoreController 
{
	@Autowired
	private AutoreService autoreService;
	
	@RequestMapping("/autori")
	public String autori() 
	{
	    return "autori";
	}
	
	@RequestMapping("/autoreStruttura")
	public String autoreStruttura()
	{
		return "autoreStruttura";
	}
	
	@RequestMapping(value="/autori", method= RequestMethod.GET)
	public String showAutori(Model model)
	{
		model.addAttribute("autori",this.autoreService.getAllAutori());
		return "autori.html";
	}
	
	@RequestMapping(value="/autori/{id}", method=RequestMethod.GET)
	public String showOpere(@PathVariable("id") Long id, Model model)
	{
		model.addAttribute("opereAutore",this.autoreService.getAutore(id));
		return "opereAutore.html";
	}
	
	@RequestMapping(value="/autoreStruttura",method=RequestMethod.GET)
	public String showMangaka(int value,Model model)
	{
		if(value==67)
		{
			model.addAttribute("autori",this.autoreService.getMangaka());
		}
		else
		{
			model.addAttribute("autori",this.autoreService.getFumettista());
		}
		return"/autoreStruttura";
	}
}