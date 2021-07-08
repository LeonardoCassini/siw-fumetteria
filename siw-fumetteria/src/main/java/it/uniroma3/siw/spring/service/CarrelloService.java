package it.uniroma3.siw.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.spring.model.Carrello;
import it.uniroma3.siw.spring.repository.CarrelloRepository;

@Service
public class CarrelloService 
{
	@Autowired
	protected CarrelloRepository carrelloRepository;
	
	@Transactional
	public Carrello saveCarrello(Carrello carrello) {
		return this.carrelloRepository.save(carrello);
	}
}
