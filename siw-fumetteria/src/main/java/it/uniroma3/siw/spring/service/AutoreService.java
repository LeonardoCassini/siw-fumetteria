package it.uniroma3.siw.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.uniroma3.siw.spring.model.Autore;
//import it.uniroma3.siw.spring.model.Opera;
import it.uniroma3.siw.spring.repository.AutoreRepository;

@Service
public class AutoreService 
{
	@Autowired
	protected AutoreRepository autoriRepository;
	
	//Metodo per recuperare un autore dal db
	
	public Autore getAutore(Long id) 
	{
		Optional<Autore> result = this.autoriRepository.findById(id);
		return result.orElse(null);
	}
	
	//Metodo per salvare un Autore dal db
	@Transactional
	public Autore saveAutore(Autore autore) 
	{
		return this.autoriRepository.save(autore);
	}
	
	//Metodo per recuperare tutti gli Autori dal db
	
	public List<Autore> getAllAutori()
	{
		List<Autore> result = new ArrayList<Autore>();
		Iterable<Autore> it = this.autoriRepository.findAll();
		for(Autore autore : it)
			result.add(autore);
		return result;
	}
	
	
	public List<Autore> getMangaka()
	{
		List<Autore> result = new ArrayList<Autore>();
		Iterable<Autore> it = this.autoriRepository.findByStruttura(77);
		for(Autore autore : it)
			result.add(autore);
		return result;
	}
	
	
	public List<Autore> getFumettista()
	{
		List<Autore> result = new ArrayList<Autore>();
		Iterable<Autore> it = this.autoriRepository.findByStruttura(67);
		for(Autore autori : it)
			result.add(autori);
		return result;
	}
	
	public void cancella(Long id)
	{
		this.autoriRepository.deleteById(id);
	}
}