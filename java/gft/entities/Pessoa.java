package gft.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_pessoa", uniqueConstraints= {
@UniqueConstraint(columnNames ={"cpf"})})
@Getter
@Setter
public class Pessoa {
	
	public Pessoa() {
		
	}
	



	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", telefone="
				+ telefone + ", partido=" + partido + ", cargo=" + cargo+ ", foto=" + foto + "]";
	}


	public Pessoa(Long id,  String nome,  String cpf,
			 Endereco endereco,  String telefone, Partido partido, Cargo cargo, String foto,
			String atribuicao) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.partido = partido;
		this.cargo = cargo;
		this.foto = foto;
		this.atribuicao = atribuicao;
	}



	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name="nome", nullable= false)
	private String nome;
	
	@NotBlank(message = "{cpf.not.blank}")
	@CPF(message="CPF inválido, digite novamente")
	@Column(name="cpf",unique=true)
	private String cpf;
	
	
	@OneToOne
	@JoinColumn(name="endereco_id")
	private Endereco endereco; 
	
	@NotBlank
	@Column(name="telefone", nullable= false)
	private String telefone;
	

	@OneToOne
	@JoinColumn(name="partido_id")
	private Partido partido;
	

	@OneToOne
	@JoinColumn(name="cargo_id")
	private Cargo cargo;
	

	@Column(name="foto")
	private String foto;
	
	@Column(name="atribuicao")
	private String atribuicao;

}
