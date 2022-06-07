package gft.entities;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tb_projetolei")
@Getter
@Setter
public class ProjetosLei {
	
	public ProjetosLei(Long id, Date data, String descricao,int numero, Pessoa pessoa) {
		this.id = id;
		this.numero = numero;
		this.data = data;
		this.descricao = descricao;
		this.pessoa = pessoa;
	}
	
	public ProjetosLei() {

	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="numero", nullable = false)
	private int numero;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data", nullable = false)
	private Date data;
	

	@Column(name="descricao")
	private String descricao;
	
	
	@OneToOne
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa;

}
