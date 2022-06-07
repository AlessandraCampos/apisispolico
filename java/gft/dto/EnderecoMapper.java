package gft.dto;
import gft.entities.Endereco;

public class EnderecoMapper {
	
	public static Endereco fromDTO(EnderecoDTO dtoEnd) {
	 Endereco endereco = new Endereco (dtoEnd.getId(), dtoEnd.getLogradouro(), dtoEnd.getNumero(), dtoEnd.getCidade(), dtoEnd.getEstado(), dtoEnd.getCep());
		 return endereco ;
	}
	
	
	public static EnderecoDTO fromEntity (Endereco endereco) {
		return new EnderecoDTO(endereco.getId(), endereco.getLogradouro(), endereco.getNumero(), endereco.getCidade(), endereco.getEstado(), endereco.getCep());
	}


}
