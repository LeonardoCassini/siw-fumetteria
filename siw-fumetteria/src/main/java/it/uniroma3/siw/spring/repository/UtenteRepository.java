package it.uniroma3.siw.spring.repository;

import org.springframework.data.repository.CrudRepository;
import it.uniroma3.siw.spring.model.Ordine;
import it.uniroma3.siw.spring.model.Utente;
import java.util.List;
import  org.springframework.data.jpa.repository.Query;

public interface UtenteRepository extends CrudRepository<Utente, Long>
{
	@Query("Select * from Ordine join Utente on Ordine.cliente.id=id")
	public List<Ordine> findOrdineByUtente(Long id);
}
