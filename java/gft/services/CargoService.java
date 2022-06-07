package gft.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gft.entities.Cargo;
import gft.exceptions.EntityNotFoundException;
import gft.repositories.CargoRepository;

@Service
public class CargoService {

	private final CargoRepository cargoRepository;

	public CargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	public Page<Cargo> buscarCargos(Pageable pageable) {

		return cargoRepository.findAll(pageable);
	}

	public Cargo salvarCargo(Cargo cargo) {

		return cargoRepository.save(cargo);

	}

	public Cargo buscarCargoId(Long id) {
		Optional<Cargo> buscarid = cargoRepository.findById(id);

		return buscarid.orElseThrow(() -> new EntityNotFoundException("Cargo não encontrado  Id: " + id));
	}

	public void deleteCargo(Long id) {
		cargoRepository.deleteById(id);

	}

	public Cargo atualizarCargo(Cargo cargo, Long id) {
		Cargo cargoId = this.buscarCargoId(id);
		cargo.setId(cargoId.getId());

		return cargoRepository.save(cargo);
	}

}
