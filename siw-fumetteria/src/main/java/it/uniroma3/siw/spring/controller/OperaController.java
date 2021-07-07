package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.spring.service.OperaService;

@Controller
public class OperaController 
{
	@Autowired
	private OperaService operaService;

	@RequestMapping("/opere")
	public String opere() 
	{
		return "opere";
	}

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

	@RequestMapping(value="/filtraOpere",method=RequestMethod.GET)
	public String showMangaComic(Model model,@RequestParam(value="action",required=true)String valore)
	{
		String manga,fumetti;
		manga="manga";
		fumetti="comic";
		if(valore.equals(manga))
		{
			model.addAttribute("opere",this.operaService.getManga(valore));
		}
		if(valore.equals(fumetti))
		{
			model.addAttribute("opere",this.operaService.getComic(valore));
		}
		if(!valore.equals(manga) && !valore.equals(fumetti))
		{
			model.addAttribute("opere",this.operaService.getAllOpere());
		}
		return"/opere";
	}
}
