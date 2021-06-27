package it.uniroma3.siw.spring.model;

import javax.persistence.*;
import java.time.*;
import java.util.List;

@Entity
public class Autore 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	private LocalDate dataMorte;
	private String nazionalita;
	private int struttura;
	@OneToMany(mappedBy="autore")
	private List<Opera> opere;
	
	public Long getId() 
	{
		return id;
	}
	public void setId(Long id) 
	{
		this.id = id;
	}
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	public String getCognome() 
	{
		return cognome;
	}
	public void setCognome(String cognome) 
	{
		this.cognome = cognome;
	}
	public LocalDate getDataNascita() 
	{
		return dataNascita;
	}
	public void setDataNascita(LocalDate dataNascita) 
	{
		this.dataNascita = dataNascita;
	}
	public LocalDate getDataMorte() 
	{
		return dataMorte;
	}
	public void setDataMorte(LocalDate dataMorte) 
	{
		this.dataMorte = dataMorte;
	}
	public String getNazionalita() 
	{
		return nazionalita;
	}
	public void setNazionalita(String nazionalita) 
	{
		this.nazionalita = nazionalita;
	}
	public int getStruttura() 
	{
		return struttura;
	}
	public void setStruttura(int struttura) 
	{
		this.struttura = struttura;
	}
	public List<Opera> getOpere() 
	{
		return opere;
	}
	public void setOpere(List<Opera> opere) 
	{
		this.opere = opere;
	}
}
