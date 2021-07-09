package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.controller.validator.VolumeValidator;
import it.uniroma3.siw.spring.model.Volume;
import it.uniroma3.siw.spring.service.OperaService;
import it.uniroma3.siw.spring.service.VolumeService;


@Controller
public class VolumeController 
{
	@Autowired
	private VolumeService volumeService;
	@Autowired
	private OperaService operaService;
	@Autowired
	private VolumeValidator volumeValidator;
	
	
	@RequestMapping("/volumi")
	public String volumi()
	{
		return "volumi";
	}
	
	@RequestMapping(value="/volume/{id}",method=RequestMethod.GET)
	public String showVolume(@PathVariable("id") String id, Model model)
	{
		model.addAttribute("volume", this.volumeService.getVolume(id));
		return"volume.html";
	}
	
	@RequestMapping(value="/inserisciVolume",method=RequestMethod.GET)
	public String inserisciVolume(Model model)
	{
		model.addAttribute("volume", new Volume());
		model.addAttribute("opere",this.operaService.getAllOpere());
		return"/inserisciVolume";
	}
	
	@RequestMapping(value="/inserisciVolume",method=RequestMethod.POST)
	public String aggiungi(@ModelAttribute("volume") Volume volume,Model model,BindingResult br)
	{
		this.volumeValidator.validate(volume, br);
		if(!br.hasErrors())
		{
			this.volumeService.saveVolume(volume);
			return "redirect:/inserisciVolume";
		}
		return"redirect:/default";
	}
}
