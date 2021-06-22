package it.uniroma3.siw.spring.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import it.uniroma3.siw.spring.model.Autore;

public interface AutoriRepository extends CrudRepository<Autore, Long>
{
	public List<Autore> findByStruttura(int struttura);
}
