package gft.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CargoDTO {

	private Long id;

	private String nome;

	private String descricao;
	
	

	public CargoDTO() {

	}

	public CargoDTO(Long id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

}
