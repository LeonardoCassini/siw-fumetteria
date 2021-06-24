package it.uniroma3.siw.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.uniroma3.siw.spring.model.Opera;
import it.uniroma3.siw.spring.model.Volume;
import it.uniroma3.siw.spring.repository.OperaRepository;

@Service
public class OperaService 
{
	@Autowired
	protected OperaRepository operaRepository;
	
	//metodo per recuperare tutte le opere
	@Transactional
	public List<Opera> getAllOpere()
	{
		List<Opera> result = new ArrayList<Opera>();
		Iterable<Opera> it= this.operaRepository.findAll();
		for(Opera Opera : it)
		{
			result.add(Opera);
		}
		return result;
	}
	
	//metodo per recuperare un Opera dal db
	@Transactional
	public Opera getOpera(Long id)
	{
		Optional<Opera> result = this.operaRepository.findById(id);
		return result.orElse(null);
	}
	
	//metodo per salvare nel db un Opera
	@Transactional
	public Opera saveOpera(Opera opera) 
	{
		return this.operaRepository.save(opera);
	}
	
	//metodo per trovare tutti i volumi
	@Transactional
	public List<Volume> getVolumi(Long id)
	{
		List<Volume> result = new ArrayList<Volume>();
		Iterable<Volume> it= this.operaRepository.findVolimiByOpera(id);
		for(Volume volumi : it)
		{
			result.add(volumi);
		}
		return result;
	}
}
