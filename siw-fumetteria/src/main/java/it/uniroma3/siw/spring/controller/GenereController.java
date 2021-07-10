package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.controller.validator.GenereValidator;
import it.uniroma3.siw.spring.model.Genere;
import it.uniroma3.siw.spring.service.GenereService;

@Controller
public class GenereController 
{
	@Autowired
	private GenereService genereService;
	@Autowired
	private GenereValidator genereValidator;
	
	@RequestMapping("/generi")
	public String generi() 
	{
	    return "generi";
	}
	
	@RequestMapping(value="/generi",method=RequestMethod.GET)
	public String showGeneri(Model model)
	{
		model.addAttribute("generi",this.genereService.getAllGeneri());
		return"generi.html";
	}
	
	@RequestMapping(value="/generi/{id}", method=RequestMethod.GET)
	public String showOpere(@PathVariable("id") Long id, Model model)
	{
		model.addAttribute("opere",this.genereService.getGenere(id));
		return "opereGenere.html";
	}
	
	@RequestMapping(value="/inserisciGenere",method=RequestMethod.GET)
	public String inserisciGenere(Model model)
	{
		model.addAttribute("genere", new Genere());
		return"/inserisciGenere";
	}
	
	@RequestMapping(value="/inserisciGenere",method=RequestMethod.POST)
	public String aggiungi(@ModelAttribute("genere") Genere genere,Model model,BindingResult br)
	{
		this.genereValidator.validate(genere, br);
		if(!br.hasErrors())
		{
			this.genereService.saveGenere(genere);
			return"redirect:/inserisciGenere";
		}
		return"redirect:/default";
	}
	
	@RequestMapping(value="/modificaGenere",method=RequestMethod.GET)
	public String iniziaModificaGenere(Model model)
	{
		model.addAttribute("generi",this.genereService.getAllGeneri());
		return"/modificaGenere";
	}
	
	@RequestMapping(value="/cancGenere/{id}",method=RequestMethod.POST)
	public String cancellaGenere(@PathVariable("id")Long id)
	{
		this.genereService.cancella(id);
		return "redirect:/modificaGenere";
	}
	@RequestMapping(value="/updGenere/{id}",method=RequestMethod.GET)
	public String getModificaGenere(@PathVariable("id")Long id,Model model)
	{
		model.addAttribute("genere",this.genereService.getGenere(id));
		return"/updGenere";
	}
	
	@RequestMapping(value="/updGenere/{id}",method=RequestMethod.POST)
	public String modificaGenere(@ModelAttribute("genere") Genere genere,Model model,BindingResult br)
	{
		this.genereValidator.validate(genere, br);
		if(!br.hasErrors())
		{
			this.genereService.saveGenere(genere);
			return"redirect:/modificaGenere";
		}
		return"redirect:/default";
	}
}
