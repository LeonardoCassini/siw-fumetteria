package it.uniroma3.siw.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.uniroma3.siw.spring.model.Utente;
import it.uniroma3.siw.spring.repository.UtenteRepository;

@Service
public class UtenteService 
{

	@Autowired
	protected UtenteRepository utenteRepository;
	
	//Metodo per recuperare un cliente dal db
	@Transactional
	public Utente getCliente(Long id) 
	{
		Optional<Utente> result = this.utenteRepository.findById(id);
		return result.orElse(null);
	}
	
	//Metodo per salvare un cliente dal db
	@Transactional
	public Utente saveCliente(Utente cliente) 
	{
		return this.utenteRepository.save(cliente);
	}
	
	//Metodo per recuperare tutti i clienti dal db
	@Transactional
	public List<Utente> getAllClienti()
	{
		List<Utente> result = new ArrayList<Utente>();
		Iterable<Utente> it = this.utenteRepository.findAll();
		for(Utente cliente : it)
			result.add(cliente);
		return result;
	}

	public Utente getClienteFromUsername(String email) {
		
		return this.utenteRepository.findByEmail(email);
	}
}
