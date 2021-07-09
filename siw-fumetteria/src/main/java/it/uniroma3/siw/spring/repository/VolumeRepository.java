package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import it.uniroma3.siw.spring.model.Volume;

public interface VolumeRepository extends CrudRepository <Volume,String>
{
	public List<Volume> findByIsbn(String isbn);
}
