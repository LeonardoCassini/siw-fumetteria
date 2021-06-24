package it.uniroma3.siw.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController 
{
	@RequestMapping(value= {"/","homePage"}, method= RequestMethod.GET)
	public String home(Model model)
	{
		return "homePage";
	}
	
	@RequestMapping("/autori")
	public String autori() 
	{
	    return "autori";
	}
	
	@RequestMapping("/news")
	public String news() 
	{
	    return "news";
	}
	
	@RequestMapping("/generi")
	public String generi() 
	{
	    return "generi";
	}
	
	@RequestMapping("/opere")
	public String opere() 
	{
	    return "opere";
	}
}
