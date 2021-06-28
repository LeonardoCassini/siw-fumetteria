package it.uniroma3.siw.spring.model;

import javax.persistence.*;
import java.time.*;
import java.util.List;


@Entity
public class Utente 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cognome;
	private String email;
	private LocalDate dataNascita;
	private String indirizzo;
	private String password;
	private String pagamento;
	@OneToMany(mappedBy="cliente")
	private List<Ordine> ordini;
	@OneToOne(mappedBy="utente")
	private Credenziali credenziali;
	@OneToOne
	private Carrello carrello;
	
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
	public String getIndirizzo() 
	{
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) 
	{
		this.indirizzo = indirizzo;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getPagamento() 
	{
		return pagamento;
	}
	public void setPagamento(String pagamento) 
	{
		this.pagamento = pagamento;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	
}
