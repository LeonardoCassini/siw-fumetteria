package it.uniroma3.siw.spring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import it.uniroma3.siw.spring.model.Ordine;

public interface OrdineRepository extends CrudRepository<Ordine,Long>
{
	@Query(value="select * from ordine where cliente_id=?1",nativeQuery=true)
	public List<Ordine> findByUtente(Long id);
}
