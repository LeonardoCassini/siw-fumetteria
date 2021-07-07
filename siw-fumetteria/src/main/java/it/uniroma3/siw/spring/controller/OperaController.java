package it.uniroma3.siw.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.spring.model.Opera;
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
	
	
	
	@RequestMapping(value="/filtraOpereGenere",method=RequestMethod.GET,params="action=manga")
	public String showMangaGenere(Model model)
	{
		model.addAttribute("opere",this.operaService.getStrutturaGenere("manga"));
		return"/genereStruttura";
	}
	
	@RequestMapping(value="/filtraOpereGenere",method=RequestMethod.GET,params="action=comic")
	public String showComicGenere(Model model)
	{
		model.addAttribute("opere",this.operaService.getStrutturaGenere("comic"));
		return"/genereStruttura";
	}
	
	@RequestMapping(value="/filtraOpereGenere",method=RequestMethod.GET,params="action=nulla")
	public String togliFiltriGenere(Model model)
	{
		model.addAttribute("opere", this.operaService.getAllOpere());
		return"/genereStruttura";
	}
	
}
