package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import it.uniroma3.siw.spring.model.Genere;


public interface GenereRepository extends CrudRepository <Genere,Long>
{
	public List<Genere> findByTipologia(String tipologia);
}
