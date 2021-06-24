package it.uniroma3.siw.spring.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Genere 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String tipologia;
	@ManyToMany
	private List <Opera> opere;

	public Long getId() 
	{
		return id;
	}

	public String getTipologia() 
	{
		return tipologia;
	}

	public void setTipologia(String tipologia) 
	{
		this.tipologia = tipologia;
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
