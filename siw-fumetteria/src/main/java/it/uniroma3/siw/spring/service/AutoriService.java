package it.uniroma3.siw.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.spring.model.Autore;
import it.uniroma3.siw.spring.repository.AutoriRepository;

@Service
public class AutoriService 
{
	@Autowired
	protected AutoriRepository autoriRepository;
	
	//Metodo per recuperare un cliente dal db
	@Transactional
	public Autore getAutore(Long id) 
	{
		Optional<Autore> result = this.autoriRepository.findById(id);
		return result.orElse(null);
	}
	
	//Metodo per salvare un cliente dal db
	@Transactional
	public Autore saveAutore(Autore cliente) 
	{
		return this.autoriRepository.save(cliente);
	}
	
	//Metodo per recuperare tutti i clienti dal db
	@Transactional
	public List<Autore> getAllAutori()
	{
		List<Autore> result = new ArrayList<Autore>();
		Iterable<Autore> it = this.autoriRepository.findAll();
		for(Autore autore : it)
			result.add(autore);
		return result;
	}
	@Transactional
	public List<Autore> getMangaka()
	{
		List<Autore> result = new ArrayList<Autore>();
		Iterable<Autore> it = this.autoriRepository.findByStruttura(77);
		for(Autore autore : it)
			result.add(autore);
		return result;
	}
	
	@Transactional
	public List<Autore> getFumettista()
	{
		List<Autore> result = new ArrayList<Autore>();
		Iterable<Autore> it = this.autoriRepository.findByStruttura(67);
		for(Autore autore : it)
			result.add(autore);
		return result;
	}
}