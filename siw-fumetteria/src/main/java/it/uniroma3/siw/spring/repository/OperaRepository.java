package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import it.uniroma3.siw.spring.model.Opera;

public interface OperaRepository extends CrudRepository <Opera, Long>
{
	public List<Opera> findByStruttura(String struttura);
	
	public List<Opera> findByNome(String nome);
	
	//public List<Opera> esiste (String )
}