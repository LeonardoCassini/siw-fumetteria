package it.uniroma3.siw.spring.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.uniroma3.siw.spring.model.Ordine;
import it.uniroma3.siw.spring.repository.OrdineRepository;

@Service
public class OrdineService 
{
	@Autowired
	protected OrdineRepository ordineRepository;
	
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
}
