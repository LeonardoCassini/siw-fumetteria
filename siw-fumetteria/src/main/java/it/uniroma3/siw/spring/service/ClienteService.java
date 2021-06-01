package it.uniroma3.siw.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.spring.model.Cliente;
import it.uniroma3.siw.spring.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	protected ClienteRepository clienteRepository;
	
	//Metodo per recuperare un cliente dal db
	@Transactional
	public Cliente getCliente(Long id) {
		Optional<Cliente> result = this.clienteRepository.findById(id);
		return result.orElse(null);
	}
	
	//Metodo per salvare un cliente dal db
	public Cliente saveCliente(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	//Metodo per recuperare tutti i clienti dal db
	@Transactional
	public List<Cliente> getAllClienti(){
		List<Cliente> result = new ArrayList<Cliente>();
		Iterable<Cliente> it = this.clienteRepository.findAll();
		for(Cliente cliente : it)
			result.add(cliente);
		return result;
	}
}
