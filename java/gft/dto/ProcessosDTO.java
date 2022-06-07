package gft.dto;


import gft.entities.Pessoa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProcessosDTO {
	public ProcessosDTO(Long id, int numero, String descricao, Pessoa pessoa) {
		this.id = id;
		this.numero = numero;
		this.descricao = descricao;
		this.pessoa = pessoa;
	}
	
	public ProcessosDTO() {
		
	}

	private Long id;

	private int numero;
	
	private String descricao;

	private Pessoa pessoa;

}
