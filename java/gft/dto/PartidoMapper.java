package gft.dto;

import gft.entities.Partido;

public class PartidoMapper {
	
	public static Partido fromDTO ( PartidoDTO partidoDTO) {
		
		Partido partido = new Partido (null,partidoDTO.getSigla(), partidoDTO.getNome());
		
		return partido;
	}
	
	public static PartidoDTO consultaFromEntity(Partido partido ) {
		
		PartidoDTO partidoDTO = new PartidoDTO(partido.getId(), partido.getSigla(),partido.getNome());
		
		return partidoDTO;
	}

}


