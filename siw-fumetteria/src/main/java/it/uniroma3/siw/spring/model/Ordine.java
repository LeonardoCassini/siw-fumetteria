package it.uniroma3.siw.spring.model;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
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
}
