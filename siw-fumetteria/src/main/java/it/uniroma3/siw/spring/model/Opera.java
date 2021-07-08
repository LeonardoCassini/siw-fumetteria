package it.uniroma3.siw.spring.model;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
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
	private String immagine;
	@ManyToOne
	private Autore autore;
	@OneToMany(mappedBy="opera")
	private List<Volume> volumi;
}
