package it.uniroma3.siw.spring.model;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;
import java.time.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
public class Utente 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cognome;
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascita;
	private String indirizzo;
	private String password;
	private String pagamento;
	@OneToMany(mappedBy="cliente")
	private List<Ordine> ordini;
	@OneToOne(mappedBy="utente")
	private Credenziali credenziali;
}
