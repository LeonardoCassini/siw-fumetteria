package it.uniroma3.siw.spring.model;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Volume 
{
	
	private int pagine;
	@Id
	private String isbn;
	private String titolo;
	private int numVolume;
	private String sinossi;
	private float prezzo;
	private String nomeCopertina;
	private String copertina;
	private int copie;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate pubblicazione;
	private boolean ristampa;
	@ManyToOne
	private Opera opera;
	@ManyToMany
	private List <Ordine> ordini;
}
