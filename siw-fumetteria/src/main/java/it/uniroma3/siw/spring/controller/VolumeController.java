package it.uniroma3.siw.spring.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uniroma3.siw.spring.controller.validator.VolumeValidator;
import it.uniroma3.siw.spring.model.Ordine;
import it.uniroma3.siw.spring.model.Utente;
import it.uniroma3.siw.spring.model.Volume;
import it.uniroma3.siw.spring.service.OperaService;
import it.uniroma3.siw.spring.service.OrdineService;
import it.uniroma3.siw.spring.service.UtenteService;
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
	@Autowired
	private OrdineService ordineService;
	@Autowired
	protected UtenteService utenteService;
	
	
	@RequestMapping("/volumi")
	public String volumi()
	{
		return "volumi";
	}
	
	@RequestMapping(value="/volume/{isbn}",method=RequestMethod.GET)
	public String showVolume(@PathVariable("isbn") String isbn, Model model)
	{
		model.addAttribute("volume", this.volumeService.getVolume(isbn));
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
	
	@RequestMapping(value="/modificaVolume",method=RequestMethod.GET)
	public String iniziaModificaVolume(Model model)
	{
		model.addAttribute("volumi",this.volumeService.getAllVolumi());
		return"/modificaVolume";
	}
	
	@RequestMapping(value="/cancVolume/{id}",method=RequestMethod.POST)
	public String cancellaVolume(@PathVariable("id")String id)
	{
		this.volumeService.cancella(id);
		return"redirect:/modificaVolume";
	}
	
	@RequestMapping(value="/updVolume/{isbn}",method=RequestMethod.GET)
	public String getModificaVolume(@PathVariable("isbn")String isbn,Model model)
	{
		model.addAttribute("volume",this.volumeService.getVolume(isbn));
		model.addAttribute("opere",this.operaService.getAllOpere());
		return"/updVolume";
	}
	
	@RequestMapping(value="/updVolume/{isbn}",method=RequestMethod.POST)
	public String modificaVolume(@ModelAttribute("volume") Volume volume,Model model,BindingResult br)
	{
		this.volumeValidator.validate(volume, br);
		if(!br.hasErrors())
		{
			this.volumeService.saveVolume(volume);
			return "redirect:/modificaVolume";
		}
		return"redirect:/default";
	}
	
	@RequestMapping(value="/addCarrello/{isbn}",method=RequestMethod.POST)
	public String AddToCart(@PathVariable("isbn") String isbn,Model model)
	{
		List<Ordine> ordiniCliente=new ArrayList<Ordine>();
		ordiniCliente=this.ordineService.OrdiniUtente();
		boolean ordineDisponibile=false;
		for(Ordine ordine : ordiniCliente)
		{
			if(ordine.getStato().equals("provvisorio")&&ordineDisponibile==false)
			{
				ordineDisponibile=true;
				ordine.getVolumi().add(this.volumeService.getVolume(isbn));
				this.ordineService.saveOrdine(ordine);
			}
		}
		
		if(ordineDisponibile==false)
		{
			Ordine ordine=new Ordine();
			List<Volume>volume=new ArrayList<Volume>();
			UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Utente cliente=this.utenteService.getClienteFromUsername(userDetails.getUsername());
			ordine.setStato("provvisorio");
			ordine.setCliente(cliente);
			volume.add(this.volumeService.getVolume(isbn));
			ordine.setVolumi(volume);
			this.ordineService.saveOrdine(ordine);
		}
		
		return"redirect:/volume/{isbn}";
	}
}
