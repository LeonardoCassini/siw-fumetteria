package it.uniroma3.siw.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Credenziali 
{

	public static final String DEFAULT_ROLE = "Default";
	public static final String ADMIN_ROLE = "Admin";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String role;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Utente utente;

	/**
	 * @return the id
	 */
	public Long getId() 
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) 
	{
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getUsername() 
	{
		return username;
	}

	/**
	 * @param email the email to set
	 */
	public void setUsername(String email) 
	{
		this.username = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() 
	{
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) 
	{
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public String getRole() 
	{
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) 
	{
		this.role = role;
	}

	/**
	 * @return the cliente
	 */
	public Utente getCliente() 
	{
		return utente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Utente utente) 
	{
		this.utente = utente;
	}
	
	
}
