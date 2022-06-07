package gft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_partido")
@Getter
@Setter
public class Partido {

	public Partido(Long id, String sigla, String nome) {
		this.id = id;
		this.sigla = sigla;
		this.nome = nome;
	}

	public Partido() {

	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name ="sigla", nullable= false)
	private String sigla;
	
	@Column(name ="nome", nullable= false)
	private String nome;
	


}
