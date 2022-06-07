package gft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_processos")
@Getter
@Setter
public class Processos {
	
	
	public Processos() {
	}

	public Processos(Long id, int numero, String descricao, Pessoa pessoa
		) {
		this.id = id;
		this.numero = numero;
		this.descricao = descricao;
		this.pessoa = pessoa;
	
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="numero")
	private int numero;
	
	
	@Column(name="descricao")
	private String descricao;
	
	@OneToOne
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa;

}
