package gft.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartidoDTO {
	
	public PartidoDTO() {
	
	}

	public PartidoDTO(Long id, String sigla, String nome) {
		this.id = id;
		this.sigla = sigla;
		this.nome = nome;
	}

	private Long id;
	
	private String sigla;
	
	private String nome;

}
