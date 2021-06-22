package it.uniroma3.siw.spring.model;

import javax.persistence.*;
import java.time.*;
import java.util.List;

@Entity
public class Ordine 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDateTime dataCreazione;
	private String stato;
	@ManyToMany
	private List<Volume> volumi;
	@ManyToOne
	private Utente cliente;
	
	public Long getId() 
	{
		return id;
	}
	public void setId(Long id) 
	{
		this.id = id;
	}
	public LocalDateTime getDataCreazione() 
	{
		return dataCreazione;
	}
	public void setDataCreazione(LocalDateTime dataCreazione) 
	{
		this.dataCreazione = dataCreazione;
	}
	public String getStato() 
	{
		return stato;
	}
	public void setStato(String stato) 
	{
		this.stato = stato;
	}
}
