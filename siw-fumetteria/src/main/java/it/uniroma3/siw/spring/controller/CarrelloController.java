package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uniroma3.siw.spring.service.CarrelloService;

@Controller
public class CarrelloController 
{
	@Autowired
	private CarrelloService carrelloService;
	
//	@RequestMapping()
//	public String showCarello(Model model)
//	{
//		model.addAttribute("volumiCarrello", this.carrelloService.)
//	}
}
