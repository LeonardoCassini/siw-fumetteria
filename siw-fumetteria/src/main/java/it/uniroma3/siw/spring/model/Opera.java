package it.uniroma3.siw.spring.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Opera 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	@ManyToMany(mappedBy="opere")
	private List<Genere> genere;
	private String sinossi;
	private String target;
	private String stato;
	private String struttura;
	private String nazionalita;
	@ManyToOne
	private Autore autore;
	@OneToMany
	private List<Volume> volumi;
	
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
//	public String getGenere() {
//		return genere;
//	}
//	public void setGenere(String genere) {
//		this.genere = genere;
//	}
	public String getSinossi() 
	{
		return sinossi;
	}
	public void setSinossi(String sinossi) 
	{
		this.sinossi = sinossi;
	}
	public String getTarget() 
	{
		return target;
	}
	public void setTarget(String target) 
	{
		this.target = target;
	}
	public String getStato() 
	{
		return stato;
	}
	public void setStato(String stato) 
	{
		this.stato = stato;
	}
	public String getStruttura() 
	{
		return struttura;
	}
	public void setStruttura(String struttura) 
	{
		this.struttura = struttura;
	}
	public String getNazionalita() 
	{
		return nazionalita;
	}
	public void setNazionalita(String nazionalita) 
	{
		this.nazionalita = nazionalita;
	}
	
	
}
