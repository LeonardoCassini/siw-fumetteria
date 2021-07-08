package it.uniroma3.siw.spring.model;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
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
	private List <Opera> opere;
}
