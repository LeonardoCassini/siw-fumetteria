package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.spring.controller.validator.AutoreValidator;
import it.uniroma3.siw.spring.model.Autore;
import it.uniroma3.siw.spring.service.AutoreService;

@Controller
public class AutoreController 
{
	@Autowired
	private AutoreService autoreService;
	@Autowired
	private AutoreValidator autoreValidator;
	
	@RequestMapping(value="/autoreStruttura")
	public String autoreStruttura()
	{
		return"/autoreStruttura";
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

	@RequestMapping(value="/filtraAutori",method=RequestMethod.GET)
	public String showFumettistiMangaka(Model model,@RequestParam(value="action",required=true)int valore)
	{
		if(valore==77)
		{
			model.addAttribute("autori",this.autoreService.getMangaka());
		}
		else if(valore==67)
		{
			model.addAttribute("autori",this.autoreService.getFumettista());
		}
		if(valore!=67&&valore!=77)
		{
			model.addAttribute("autori",this.autoreService.getAllAutori());
		}
		return"/autori";
	}
	
	@RequestMapping(value="/inserisciAutore",method = RequestMethod.GET)
	public String inserisciAutore(Model model)
	{
			model.addAttribute("autore", new Autore());
			return"/inserisciAutore";
	}
	
	@RequestMapping(value="/inserisciAutore", method=RequestMethod.POST)
	public String aggiungi(@ModelAttribute("autore") Autore autore,Model model,BindingResult br)
	{
		this.autoreValidator.validate(autore,br);
		if(!br.hasErrors())
		{
			this.autoreService.saveAutore(autore);
			return "redirect:/inserisciAutore";
		}
		return"redirect:/default";
	}
	
	@RequestMapping(value="/modificaAutore", method=RequestMethod.GET)
	public String iniziaModificaAutore(Model model)
	{
		model.addAttribute("autori", this.autoreService.getAllAutori());
		return"/modificaAutore";
	}
	
	@RequestMapping(value="/cancAutore/{id}", method=RequestMethod.POST)
	public String cancellaAutore(@PathVariable("id")Long id)
	{
		this.autoreService.cancella(id);
		return"redirect:/modificaAutore";
	}
	
	@RequestMapping(value="/updAutore/{id}", method=RequestMethod.GET)
	public String getmodificaAutore(@PathVariable("id")Long id,Model model)
	{
		model.addAttribute("autore", this.autoreService.getAutore(id));;
		return"/updAutore";
	}
	
	@RequestMapping(value="/updAutore/{id}", method=RequestMethod.POST)
	public String modificaAutore(@ModelAttribute("autore") Autore autore,Model model,BindingResult br)
	{
		this.autoreValidator.validate(autore,br);
		if(!br.hasErrors())
		{
			this.autoreService.saveAutore(autore);
			return "redirect:/modificaAutore";
		}
		return"redirect:/default";
	}
}