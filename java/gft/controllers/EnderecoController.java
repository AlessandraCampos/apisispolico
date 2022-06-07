package gft.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gft.dto.EnderecoDTO;
import gft.dto.EnderecoMapper;

import gft.entities.Endereco;

import gft.services.EnderecoService;

@RestController
@RequestMapping("api/endereco")
public class EnderecoController {

	private EnderecoService enderecoService;

	public EnderecoController(EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}

	@GetMapping
	public ResponseEntity<List<EnderecoDTO>> listarEndereco() {

		return ResponseEntity.ok(enderecoService.buscarEnderecos().stream().map(EnderecoMapper::fromEntity)
				.collect(Collectors.toList()));
	}

	@PostMapping
	public ResponseEntity<EnderecoDTO> salvarEndereco(@Valid @RequestBody EnderecoDTO enderecoDTO) {

		try {
			Endereco novoEndereco = enderecoService.salvarEndereco(EnderecoMapper.fromDTO(enderecoDTO));
			return ResponseEntity.ok(EnderecoMapper.fromEntity(novoEndereco));

		} catch (RuntimeException Re) {
			return ResponseEntity.notFound().build();
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<EnderecoDTO> buscarEnderecoPorId(@PathVariable Long id) {

		try {
			Endereco getEndId = enderecoService.buscarEnderecoPorId(id);
			return ResponseEntity.ok(EnderecoMapper.fromEntity(getEndId));
		} catch (RuntimeException Re) {
			return ResponseEntity.notFound().build();
		}

	}

	@PutMapping("{id}")
	public ResponseEntity<EnderecoDTO> atualizarPolitico(@RequestBody EnderecoDTO enderecoDTO, @PathVariable Long id) {
		try {
			Endereco novaEndereco = enderecoService.alterarEndereco(EnderecoMapper.fromDTO(enderecoDTO), id);

			return ResponseEntity.ok(EnderecoMapper.fromEntity(novaEndereco));

		} catch (RuntimeException Re) {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("{id}")
	public ResponseEntity<EnderecoDTO> deletarEndereco(@PathVariable Long id) {
		try {
			enderecoService.excluirEndereco(id);

			return ResponseEntity.ok().build();

		} catch (RuntimeException Re) {
			return ResponseEntity.notFound().build();
		}

	}

}
