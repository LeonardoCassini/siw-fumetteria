package it.uniroma3.siw.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.uniroma3.siw.spring.model.Ordine;
import it.uniroma3.siw.spring.model.Utente;
import it.uniroma3.siw.spring.model.Volume;
import it.uniroma3.siw.spring.repository.OrdineRepository;

@Service
public class OrdineService 
{
	@Autowired
	protected OrdineRepository ordineRepository;
	@Autowired
	protected UtenteService utenteService;
	@Autowired
	protected VolumeService volumeService;
	
	
	@Transactional
	public Ordine saveOrdine(Ordine ordine)
	{
		return this.ordineRepository.save(ordine);
	}
	
	@Transactional
	public Ordine getOrdine(Long id)
	{
		Optional<Ordine> result = this.ordineRepository.findById(id);
		return result.orElse(null);
	}
	
	public List<Ordine> OrdiniUtente()
	{
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Utente cliente=this.utenteService.getClienteFromUsername(userDetails.getUsername());
		List<Ordine> ordini=this.ordineRepository.findByUtente(cliente.getId());
		return ordini;
		
	}
	
	public List<Volume> carrello()
	{
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Utente cliente=this.utenteService.getClienteFromUsername(userDetails.getUsername());
		List<Volume> volumi=new ArrayList<Volume>();
		Ordine ordine=this.ordineRepository.findCarrello(cliente.getId());
		if(ordine==null)
		{
			volumi=null;
		}
		else
		{
			volumi=ordine.getVolumi();
		}
		return volumi;
	}
	
	public float getTotale()
	{
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Utente cliente=this.utenteService.getClienteFromUsername(userDetails.getUsername());
		Ordine ordine=this.ordineRepository.findCarrello(cliente.getId());
		float totale;
		if(ordine==null)
		{
			totale=0;
		}
		else
		{
			totale=ordine.getTotale();
		}
		return totale;
	}
	
	public void cancella(Long id)
	{
		this.ordineRepository.deleteById(id);
	}
}
