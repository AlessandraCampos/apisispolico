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

import gft.dto.ProjetoLeiDTO;
import gft.dto.ProjetoLeiMapper;
import gft.entities.ProjetosLei;
import gft.services.ProjetoLeiService;

@RestController
@RequestMapping("/api/projetosdelei")
public class ProjetoLeiController {

	private final ProjetoLeiService projetoLeiService;

	public ProjetoLeiController(ProjetoLeiService projetoLeiService) {
		this.projetoLeiService = projetoLeiService;

	}

	@GetMapping
	public ResponseEntity<Page<ProjetoLeiDTO>> buscarProjetosDeLei(@PageableDefault Pageable pageable) {

		return ResponseEntity.ok(projetoLeiService.ListarProjetosLei(pageable).map(ProjetoLeiMapper::fromEntity));

	}

	@GetMapping("{id}")
	public ResponseEntity<ProjetoLeiDTO> buscarProjetosDeLeiPorId(@PathVariable Long id) {

		ProjetosLei projeto = projetoLeiService.buscarProjetoPorId(id);

		return ResponseEntity.ok(ProjetoLeiMapper.fromEntity(projeto));

	}

	@PostMapping
	public ResponseEntity<ProjetoLeiDTO> salvarProjetoDeLei(@RequestBody ProjetoLeiDTO projetoLeiDTO) {
		try {
			ProjetosLei projeto = projetoLeiService.salvarProjeto(ProjetoLeiMapper.fromDTO(projetoLeiDTO));
			return ResponseEntity.ok(ProjetoLeiMapper.fromEntity(projeto));
		} catch (RuntimeException Re) {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("{id}")
	public ResponseEntity<ProjetoLeiDTO> atualizarProjetoLei(@RequestBody ProjetoLeiDTO projetoLeiDTO,
			@PathVariable Long id) {
		try {
			ProjetosLei projeto = projetoLeiService.atualizarProjetoLei(ProjetoLeiMapper.fromDTO(projetoLeiDTO), id);

			return ResponseEntity.ok(ProjetoLeiMapper.fromEntity(projeto));
		} catch (RuntimeException Re) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<ProjetoLeiDTO> deleteProjeto(@PathVariable Long id) {
		try {
		projetoLeiService.deleteProjeto(id);
		return ResponseEntity.ok().build();
		}catch(RuntimeException Re) {
		return ResponseEntity.notFound().build();
		}
		}
	}


