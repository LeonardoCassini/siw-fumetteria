package it.uniroma3.siw.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.uniroma3.siw.spring.repository.CarrelloRepository;

@Service
public class CarrelloService 
{
	@Autowired
	protected CarrelloRepository carrelloRepository;
	
	//public List<Carrello> getAll
}
