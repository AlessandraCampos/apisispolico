package gft.dto;


import gft.entities.Processos;

public class ProcessosMapper {
	
	public static Processos fromDTO (ProcessosDTO processosDTO) {
		return new	Processos (processosDTO.getId(),processosDTO.getNumero(),processosDTO.getDescricao(),processosDTO.getPessoa());
		
	}
	
	public static ProcessosDTO fromEntity(Processos processos) {
		
		return new ProcessosDTO(processos.getId(),processos.getNumero(),processos.getDescricao(),processos.getPessoa());
	}

}
