package gft.dto;

import gft.entities.Cargo;
import gft.entities.Endereco;
import gft.entities.Partido;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDTO {
	
	public PessoaDTO(Long id, String nome, String cpf, Endereco endereco, String telefone, Partido partido, Cargo cargo,
			String foto , String atribuicao) {
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

	public PessoaDTO() {
	}

	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private Endereco endereco; 
	
	private String telefone;
	
	private Partido partido;
	
	private Cargo cargo;
	
	private String foto;
	
	private String atribuicao;

}
