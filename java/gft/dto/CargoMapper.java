package gft.dto;

import gft.entities.Cargo;

public class CargoMapper {
	
	
	public static Cargo fromDTO(CargoDTO dto) {

		Cargo cargo = new Cargo(null,dto.getNome(),dto.getDescricao());
		return cargo;
	}
	

	public static CargoDTO  ConsultafromEntity(Cargo cargo) {
		return new CargoDTO(cargo.getId(),cargo.getNome(),cargo.getDescricao());
	}

}
