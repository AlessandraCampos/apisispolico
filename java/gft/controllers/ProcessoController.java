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

import gft.dto.ProcessosDTO;
import gft.dto.ProcessosMapper;
import gft.entities.Processos;
import gft.services.ProcessosService;

@RestController
@RequestMapping("/api/processos")
public class ProcessoController {

	private final ProcessosService processosService;

	public ProcessoController(ProcessosService processosService) {
		this.processosService = processosService;
	}

	@GetMapping
	public ResponseEntity<Page<ProcessosDTO>> listarProcessos(@PageableDefault Pageable pageable) {

		return ResponseEntity.ok(processosService.listarProcessos(pageable).map(ProcessosMapper::fromEntity));

	}

	@PostMapping
	public ResponseEntity<ProcessosDTO> salvarProcesso(@RequestBody ProcessosDTO processosDTO) {
		try {
			Processos novoProcesso = processosService.salvarProcesso(ProcessosMapper.fromDTO(processosDTO));
			return ResponseEntity.ok(ProcessosMapper.fromEntity(novoProcesso));
		} catch (RuntimeException Re) {
			return ResponseEntity.notFound().build();
		}

	}

	@GetMapping("{id}")
	public ResponseEntity<ProcessosDTO> buscarProcessoPorId(@PathVariable Long id) {

		Processos processoId = processosService.buscarProcessoPorId(id);

		return ResponseEntity.ok(ProcessosMapper.fromEntity(processoId));
	}

	@DeleteMapping("{id}")
	public void deletarProcesso(@PathVariable Long id) {
		try {
			processosService.deleteProcesso(id);
		} catch (RuntimeException Re) {
			Re.printStackTrace();
		}
	}

	@PutMapping("{id}")
	public ResponseEntity<ProcessosDTO> atualizarProcessos(@RequestBody ProcessosDTO processosDTO,
			@PathVariable Long id) {
		try {
			Processos processoOriginal = processosService.atualizarProcesso(ProcessosMapper.fromDTO(processosDTO), id);
			return ResponseEntity.ok(ProcessosMapper.fromEntity(processoOriginal));
		} catch (RuntimeException Re) {
			return ResponseEntity.notFound().build();
		}

	}

}
