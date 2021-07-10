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
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST,CascadeType.DETACH})
	@JoinTable(name = "genere_opere", joinColumns = { @JoinColumn(name = "opera_id") }, inverseJoinColumns = {
            @JoinColumn(name = "genere_id") })
	private List<Genere> genere;
	private String sinossi;
	private String target;
	private String stato;
	private String struttura;
	private String nazionalita;
	private String immagine;
	@ManyToOne
	private Autore autore;
	@OneToMany(mappedBy="opera",cascade=CascadeType.REMOVE)
	private List<Volume> volumi;
}
