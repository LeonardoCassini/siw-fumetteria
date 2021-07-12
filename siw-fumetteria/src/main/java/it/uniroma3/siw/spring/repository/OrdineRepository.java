package it.uniroma3.siw.spring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import it.uniroma3.siw.spring.model.Ordine;

public interface OrdineRepository extends CrudRepository<Ordine,Long>
{
	@Query(value="select * from ordine where cliente_id=?1",nativeQuery=true)
	public List<Ordine> findByUtente(Long id);
	
	@Query(value="select * from ordine where cliente_id=?1 and stato='provvisorio'",nativeQuery=true)
	public Ordine findCarrello(Long id);
	
//	@Query(value="select volume_id from volumi_ordini where ordini_id=?1",nativeQuery=true)
//	public List<String> trovaVolumiCarrello(Long id);
}
