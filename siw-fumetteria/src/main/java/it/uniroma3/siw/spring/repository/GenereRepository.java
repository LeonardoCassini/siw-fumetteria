package it.uniroma3.siw.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import it.uniroma3.siw.spring.model.Genere;
import it.uniroma3.siw.spring.model.Opera;

public interface GenereRepository extends CrudRepository <Genere,Long>
{
	@Query("Select * from Opere join Genere on Opera.genere.id=idGenere")
	public List<Opera> findOpereByGenere(Long idGenere);
}
