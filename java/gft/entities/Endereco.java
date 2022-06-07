package gft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_endereco")
@Getter
@Setter
public class Endereco {
    
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name="logradouro")
	private String logradouro;
	
	@NotBlank
	@Column(name="numero")
	private String numero;	
	
	@NotBlank
	@Column(name="cidade")
	private String cidade;
	
	@NotBlank
	@Column(name="estado")
	private String estado;
	
	@NotBlank
	@Column(name="cep")
	private String cep;
	
	public Endereco() {
	}
	
	public Endereco(Long id, String logradouro, String numero, String cidade, String estado, String cep) {
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}
}

