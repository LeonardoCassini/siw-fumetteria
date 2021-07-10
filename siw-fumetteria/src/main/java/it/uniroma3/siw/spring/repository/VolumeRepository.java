package it.uniroma3.siw.spring.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import it.uniroma3.siw.spring.model.Volume;

public interface VolumeRepository extends CrudRepository <Volume,String>
{
	@Query(value="select * from volume where isbn=?1 and copertina=?2 and copie=?3 and nome_copertina=?4 "
	+ "and num_volume=?5 and pagine=?6 and prezzo=?7 and pubblicazione=?8 and ristampa=?9 and sinossi=?10 and titolo=?11 and opera_id=?12",nativeQuery=true)
	public List<Volume> esiste(String isbn,String copertina,int copie, String nomeCopertina,int numVolume,int pagine,float prezzo,LocalDate pubblicazione,boolean ristampa,String sinossi,String titolo,Long id);
}
