package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.controller.validator.ModificaOperaValidator;
import it.uniroma3.siw.spring.controller.validator.OperaValidator;
import it.uniroma3.siw.spring.model.Opera;
import it.uniroma3.siw.spring.service.AutoreService;
import it.uniroma3.siw.spring.service.GenereService;
import it.uniroma3.siw.spring.service.OperaService;

@Controller
public class OperaController 
{
	@Autowired
	private OperaService operaService;
	@Autowired
	private OperaValidator operaValidator;
	@Autowired
	private GenereService genereService;
	@Autowired
	private AutoreService autoreService;
	@Autowired
	private ModificaOperaValidator modificaOperaValidator;

	@RequestMapping("/opereAutore")
	public String opereAutore()
	{
		return"opereAutore";
	}

	@RequestMapping("/opereGenere")
	public String opereGenere()
	{
		return"opereGenere";
	}

	@RequestMapping(value="/opere", method= RequestMethod.GET)
	public String showOpere(Model model)
	{
		model.addAttribute("opere", this.operaService.getAllOpere());
		return"opere.html";
	}

	@RequestMapping(value="/opera/{id}",method=RequestMethod.GET)
	public String showVolumiOpera(@PathVariable("id") Long id,Model model)
	{
		model.addAttribute("volumi", this.operaService.getOpera(id));
		return "volumi.html";
	}
	
	@RequestMapping(value="/filtraOpere",method=RequestMethod.GET,params="action=manga")
	public String showManga(Model model)
	{
		model.addAttribute("opere",this.operaService.getOperaByStruttura("manga"));
		return"/opere";
	}
	
	@RequestMapping(value="/filtraOpere",method=RequestMethod.GET,params="action=comic")
	public String showComic(Model model)
	{
		model.addAttribute("opere",this.operaService.getOperaByStruttura("comic"));
		return"/opere";
	}
	
	@RequestMapping(value="/filtraOpere",method=RequestMethod.GET,params="action=nulla")
	public String togliFiltri(Model model)
	{
		model.addAttribute("opere", this.operaService.getAllOpere());
		return"/opere";
	}
	
	@RequestMapping(value="/inserisciOpera",method=RequestMethod.GET)
	public String inserisciOpera(Model model)
	{
		model.addAttribute("opera",new Opera());
		model.addAttribute("generi",this.genereService.getAllGeneri());
		model.addAttribute("autori",this.autoreService.getAllAutori());
		return"/inserisciOpera";
	}
	
	
	@RequestMapping(value="/inserisciOpera",method=RequestMethod.POST)
	public String aggiungi(@ModelAttribute("opera")Opera opera,BindingResult br)
	{
		this.operaValidator.validate(opera, br);
		if(!br.hasErrors())
		{
			this.operaService.saveOpera(opera);
			return"redirect:/inserisciOpera";
		}
		return"redirect:/default";
	}
	
	@RequestMapping(value="/modificaOpera",method=RequestMethod.GET)
	public String iniziaModificaOpera(Model model)
	{
		model.addAttribute("opere", this.operaService.getAllOpere());
		return"/modificaOpera";
	}
	
	@RequestMapping(value="/cancOpera/{id}",method=RequestMethod.POST)
	public String cancellaOpera(@PathVariable("id")Long id)
	{
		this.operaService.cancella(id);
		return"redirect:/modificaOpera";
	}
	
	@RequestMapping(value="/updOpera/{id}",method=RequestMethod.GET)
	public String getModificaOpera(@PathVariable("id")Long id,Model model)
	{
		model.addAttribute("opera",this.operaService.getOpera(id));
		model.addAttribute("generi",this.genereService.getAllGeneri());
		model.addAttribute("autori",this.autoreService.getAllAutori());
		return"/updOpera";
	}
	
	@RequestMapping(value="/updOpera/{id}",method=RequestMethod.POST)
	public String modificaOpera(@ModelAttribute("opera")Opera opera,Model model,BindingResult br)
	{
		this.modificaOperaValidator.validate(opera, br);
		if(!br.hasErrors())
		{
			this.operaService.saveOpera(opera);
			return"redirect:/modificaOpera";
		}
		return"redirect:/default";
	}
}
