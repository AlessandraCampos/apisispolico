package gft.controllers;

import java.util.List;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
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
import gft.dto.PessoaDTO;
import gft.dto.PessoaMapper;
import gft.entities.Pessoa;
import gft.services.PessoaService;

@RestController
@RequestMapping("/api")
public class PessoaController {

	private PessoaService pessoaService;

	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;

	}

	@GetMapping("/politicos")
	public ResponseEntity<List<PessoaDTO>> bucarTodosPoliticos() {

		return ResponseEntity
				.ok(pessoaService.listarPessoas().stream().map(PessoaMapper::fromEntity).collect(Collectors.toList()));
	}

	@PostMapping()
	public ResponseEntity<PessoaDTO> salvarPolitico(@RequestBody @Valid PessoaDTO pessoaDTO) {
		try {
			Pessoa novapessoa = pessoaService.salvarPessoa(PessoaMapper.fromDTO(pessoaDTO));
			return new ResponseEntity<>(PessoaMapper.fromEntity(novapessoa), HttpStatus.CREATED);
		} catch (RuntimeException Re) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<PessoaDTO> buscarPoliticoPorId(@PathVariable Long id) {

		Pessoa getPessoaId = pessoaService.buscarPorId(id);

		return ResponseEntity.ok(PessoaMapper.fromEntity(getPessoaId));

	}

	@PutMapping("/{id}")
	public ResponseEntity<PessoaDTO> atualizarPolitico(@RequestBody PessoaDTO pessoaDTO, @PathVariable Long id) {
		try {
			Pessoa novapessoa = pessoaService.atualizarPessoa(PessoaMapper.fromDTO(pessoaDTO), id);

			return ResponseEntity.ok(PessoaMapper.fromEntity(novapessoa));
		} catch (RuntimeException Re) {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CargoDTO> deletarPolitico(@PathVariable Long id) {
		try {
			pessoaService.excluirPolitico(id);
			return ResponseEntity.ok().build();
		} catch (RuntimeException Re) {
			return ResponseEntity.notFound().build();
		}
	}
}
