package gft.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {
	
	public EnderecoDTO() {
	
	}
	private Long id;
	private String logradouro;
	private String numero;
	private String cidade;
	private String estado;
	private String cep;
	
	public EnderecoDTO(Long id, String logradouro, String numero, String cidade, String estado, String cep) {		
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}
	
	

}
