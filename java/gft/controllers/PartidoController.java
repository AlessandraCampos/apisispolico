package gft.controllers;

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

import gft.dto.PartidoDTO;
import gft.dto.PartidoMapper;
import gft.entities.Partido;
import gft.services.PartidoService;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

	private final PartidoService partidoService;

	public PartidoController(PartidoService partidoService) {
		this.partidoService = partidoService;

	}

	@GetMapping
	public ResponseEntity<Page<PartidoDTO>> buscarPartidos(@PageableDefault Pageable pageable) {

		return ResponseEntity.ok(partidoService.buscarPartidos(pageable).map(PartidoMapper::consultaFromEntity));

	}

	@PostMapping
	public ResponseEntity<PartidoDTO> salvarPartido(@RequestBody PartidoDTO partidoDTO) {
		try {

			Partido novoPartido = partidoService.salvarPartido(PartidoMapper.fromDTO(partidoDTO));

			return ResponseEntity.ok(PartidoMapper.consultaFromEntity(novoPartido));
		} catch (RuntimeException Re) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<PartidoDTO> buscarPartidoPorId(@PathVariable Long id) {

		Partido partidoId = partidoService.buscarPartidoById(id);

		return ResponseEntity.ok(PartidoMapper.consultaFromEntity(partidoId));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<PartidoDTO> deletePartido(@PathVariable Long id) {
		try {
			partidoService.deletePartido(id);
			return ResponseEntity.ok().build();
		} catch (RuntimeException Re) {
			return ResponseEntity.notFound().build();
		}

	}

	@PutMapping("{id}")
	public ResponseEntity<PartidoDTO> updatePartido(@RequestBody PartidoDTO partidoDTO, @PathVariable Long id) {
		try {
			Partido getIdPartido = partidoService.updatePartido(PartidoMapper.fromDTO(partidoDTO), id);
			return ResponseEntity.ok(PartidoMapper.consultaFromEntity(getIdPartido));
		} catch (RuntimeException Re) {
			return ResponseEntity.notFound().build();
		}

	}
}
