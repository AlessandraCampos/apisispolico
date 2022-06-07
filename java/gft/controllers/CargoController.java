package gft.controllers;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gft.dto.CargoDTO;
import gft.dto.CargoMapper;
import gft.entities.Cargo;
import gft.services.CargoService;

@RestController
@RequestMapping("/api")
public class CargoController {

	private final CargoService cargoService;

	public CargoController(CargoService cargoService) {
		this.cargoService = cargoService;
	}

	@GetMapping("/cargos")
	public ResponseEntity<Page<CargoDTO>> buscarTodosCargos(@PageableDefault Pageable pageable) {

		return ResponseEntity.ok(cargoService.buscarCargos(pageable).map(CargoMapper::ConsultafromEntity));

	}

	@GetMapping("/cargos/{id}")
	public ResponseEntity<CargoDTO> buscarCargoPorId(@PathVariable Long id) {

		Cargo cargo = cargoService.buscarCargoId(id);

		return ResponseEntity.ok(CargoMapper.ConsultafromEntity(cargo));
	}

	@PostMapping("/cargos")
	public ResponseEntity<CargoDTO> salvarCargo(@RequestBody @Valid CargoDTO cargoDTO) {

		try {

			Cargo cargo = cargoService.salvarCargo(CargoMapper.fromDTO(cargoDTO));

			return ResponseEntity.ok(CargoMapper.ConsultafromEntity(cargo));
		} catch (Exception rte) {
			return ResponseEntity.badRequest().build();

		}
	}

	@DeleteMapping("/cargos/{id}")
	public ResponseEntity<CargoDTO> deleteCargo(@PathVariable Long id) {

		try {
			cargoService.deleteCargo(id);
			return ResponseEntity.ok().build();

		} catch (RuntimeException Re) {
			return ResponseEntity.notFound().build();
		}

	}

	@PutMapping("/cargos/{id}")
	public ResponseEntity<CargoDTO> atualizarCargo(@RequestBody CargoDTO cargoDTO, @PathVariable Long id) {

		try {
			Cargo cargoId = cargoService.atualizarCargo(CargoMapper.fromDTO(cargoDTO), id);
			return ResponseEntity.ok(CargoMapper.ConsultafromEntity(cargoId));

		} catch (RuntimeException Re) {
			return ResponseEntity.notFound().build();
		}

	}

}
