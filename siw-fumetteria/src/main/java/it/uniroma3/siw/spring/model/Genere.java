package it.uniroma3.siw.spring.model;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Genere 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String tipologia;
	@ManyToMany
	@JoinTable(name = "genere_opere", joinColumns = { @JoinColumn(name = "genere_id") }, inverseJoinColumns = {
            @JoinColumn(name = "opera_id") })
	private List <Opera> opere;
}
