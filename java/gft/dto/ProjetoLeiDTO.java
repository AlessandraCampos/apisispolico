package gft.dto;

import java.util.Date;
import gft.entities.Pessoa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjetoLeiDTO {

	public ProjetoLeiDTO(Long id, Date data, String descricao,int numero, Pessoa pessoa) {
		this.id = id;
		this.numero = numero;
		this.data = data;
		this.descricao = descricao;
		this.pessoa = pessoa;
	}


	public ProjetoLeiDTO() {
	}


	private Long id;

	private int numero;

	private Date data;
	
	private String descricao;
	
	private  Pessoa pessoa;

}
