package it.uniroma3.siw.spring.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Carrello 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToMany(mappedBy="carrello")
	private List<Volume> volumi;
	@OneToOne(mappedBy="carrello")
	private Utente cliente;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Volume> getVolumi() {
		return volumi;
	}
	public void setVolumi(List<Volume> volumi) {
		this.volumi = volumi;
	}
	public Utente getCliente() {
		return cliente;
	}
	public void setCliente(Utente cliente) {
		this.cliente = cliente;
	}
}
