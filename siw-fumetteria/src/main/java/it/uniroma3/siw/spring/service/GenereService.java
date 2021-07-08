package it.uniroma3.siw.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.uniroma3.siw.spring.repository.GenereRepository;
import it.uniroma3.siw.spring.model.Genere;

@Service
public class GenereService 
{
	@Autowired
	protected GenereRepository genereRepository;
	
	//metodo per recuperare tutti i generi
	@Transactional
	public List<Genere> getAllGeneri()
	{
		List<Genere> result = new ArrayList<Genere>();
		Iterable<Genere> it= this.genereRepository.findAll();
		for(Genere generi : it)
		{
			result.add(generi);
		}
		return result;
	}
	
	//metodo per recuperare un genere dal db
	
	public Genere getGenere(Long id)
	{
		Optional<Genere> result = this.genereRepository.findById(id);
		return result.orElse(null);
	}
	
	//metodo per salvare nel db un genere
	@Transactional
	public Genere saveGenere(Genere genere) 
	{
		return this.genereRepository.save(genere);
	}
	
	public boolean duplicato(Genere genere)
	{
		List<Genere> generi=this.genereRepository.findByTipologia(genere.getTipologia());
		if(generi.size()>0)
		{
			return true;
		}
		return false;
	}
}
