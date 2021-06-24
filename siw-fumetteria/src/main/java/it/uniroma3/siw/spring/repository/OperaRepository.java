package it.uniroma3.siw.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import it.uniroma3.siw.spring.model.Opera;
import it.uniroma3.siw.spring.model.Volume;

public interface OperaRepository extends CrudRepository <Opera, Long>
{
	@Query("Select * from Volumi join Opera on Volumi.opera.id=idOpera")
	public List<Volume> findVolimiByOpera(Long idOpera);
}