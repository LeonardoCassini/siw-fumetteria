package it.uniroma3.siw.spring.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uniroma3.siw.spring.model.Ordine;
import it.uniroma3.siw.spring.model.Volume;
import it.uniroma3.siw.spring.service.OrdineService;
import it.uniroma3.siw.spring.service.VolumeService;

@Controller
public class OrdineController 
{
	@Autowired
	private OrdineService ordineService;
	@Autowired
	private VolumeService volumeService;
	
	@RequestMapping(value="/rimuovi/{isbn}",method=RequestMethod.POST)
	public String rimuoviVolume(@PathVariable("isbn")String isbn)
	{
		List<Ordine> ordiniCliente=new ArrayList<Ordine>();
		ordiniCliente=this.ordineService.OrdiniUtente();
		boolean carrelloTrovato=false;
		for(Ordine ordine : ordiniCliente)
		{
			if(ordine.getStato().equals("provvisorio")&& carrelloTrovato==false)
			{
				carrelloTrovato=true;
				ordine.getVolumi().remove(this.volumeService.getVolume(isbn));
				this.ordineService.saveOrdine(ordine);
			}
		}
		return"redirect:/carrello";
	}
	
	
	@RequestMapping(value="/compra",method=RequestMethod.POST)
	public String checkOut()
	{
		List<Ordine> ordiniCliente=new ArrayList<Ordine>();
		ordiniCliente=this.ordineService.OrdiniUtente();
		for(Ordine ordine : ordiniCliente)
		{
			if(ordine.getStato().equals("provvisorio"))
			{
				for(Volume volume: ordine.getVolumi())
				{
					volume.setCopie(volume.getCopie()-1);
					this.volumeService.saveVolume(volume);
				}
				ordine.setStato("In lavorazione");
				ordine.setDataCreazione(LocalDateTime.now());
				this.ordineService.saveOrdine(ordine);
			}
		}
		
		return"redirect:/homePage";
	}
}
