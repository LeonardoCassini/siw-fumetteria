package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.service.VolumeService;


@Controller
public class VolumeController 
{
	@Autowired
	private VolumeService volumeService;
	
	
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
}
