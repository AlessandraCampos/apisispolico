package gft.dto;
import gft.entities.ProjetosLei;

public class ProjetoLeiMapper {
	
	
	public static ProjetosLei fromDTO (ProjetoLeiDTO projetoLeiDTO) {
		
	return new ProjetosLei(null,projetoLeiDTO.getData(),projetoLeiDTO.getDescricao(),projetoLeiDTO.getNumero(),projetoLeiDTO.getPessoa());
		
	}

	public static ProjetoLeiDTO fromEntity ( ProjetosLei projetosLei) {
		
		return new ProjetoLeiDTO(projetosLei.getId(),projetosLei.getData(),projetosLei.getDescricao(),projetosLei.getNumero(),projetosLei.getPessoa());
	
	}
	


}
