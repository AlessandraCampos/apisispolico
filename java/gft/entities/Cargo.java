package gft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tb_cargo")
@Getter
@Setter
public class Cargo {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank (message = "Campo não estar vazio")
	@Column(name="nome")
	@Pattern(regexp="^[A-Z]+(.)*")
	private String nome;
	
	
	@Column(name="descricao",length = 60)
	private String descricao;
	
	public Cargo(Long id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Cargo() {
	
	}

	

}
