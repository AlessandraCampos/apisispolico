package gft.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gft.dto.PessoaDTO;
import gft.dto.PessoaMapper;
import gft.services.PessoaService;


@RestController
@RequestMapping("/api")
public class CargoPolitico {
	
	private PessoaService pessoaService;
	
	public CargoPolitico (PessoaService pessoaService) {
		this.pessoaService = pessoaService;
		
	}
	
	
	
	@GetMapping(value="/vereadores/asc")
	public ResponseEntity<Page<PessoaDTO>>buscaPorVereador(@PageableDefault Pageable pageable, String vereador){

		return ResponseEntity.ok(
				pessoaService.listarCargoVereador(vereador, pageable)
				.map(PessoaMapper :: fromEntity));
				}
	
	@GetMapping(value="/vereadores/desc")
	public ResponseEntity<Page<PessoaDTO>>buscaPorVereadorDesc (@PageableDefault Pageable pageable, String vereador){
		
		return ResponseEntity.ok(
				pessoaService.listarCargoVereadorDesc(vereador, pageable)
				.map(PessoaMapper :: fromEntity));
				}
	
	@GetMapping(value="/governadores/asc")
	public ResponseEntity<Page<PessoaDTO>>buscaPorGovernador(@PageableDefault Pageable pageable, String governador){

		return ResponseEntity.ok(
				pessoaService.listarCargoGovernador(governador, pageable)
				.map(PessoaMapper :: fromEntity));
				}
	
	@GetMapping(value="/governadores/desc")
	public ResponseEntity<Page<PessoaDTO>>buscaPorGovernadorDesc (@PageableDefault Pageable pageable, String governador){
		
		return ResponseEntity.ok(
				pessoaService.listarCargoGovernadorDesc(governador, pageable)
				.map(PessoaMapper :: fromEntity));
				}
	
	@GetMapping(value="/deputadosestaduais/asc")
	public ResponseEntity<Page<PessoaDTO>>buscaPorDepEstadual(@PageableDefault Pageable pageable, String depEstadual){

		return ResponseEntity.ok(
				pessoaService.listarCargoDepEst(depEstadual, pageable)
				.map(PessoaMapper :: fromEntity));
				}
	
	@GetMapping(value="/deputadosestaduais/desc")
	public ResponseEntity<Page<PessoaDTO>>bucarPorDepEstadualDesc (@PageableDefault Pageable pageable, String depEstadual){
		
		return ResponseEntity.ok(
				pessoaService.listarCargoDepEstDesc(depEstadual, pageable)
				.map(PessoaMapper :: fromEntity));
				}
	
	@GetMapping(value="/deputadosfederal/asc")
	public ResponseEntity<Page<PessoaDTO>>buscaPorDepFederal(@PageableDefault Pageable pageable, String depFederal){

		return ResponseEntity.ok(
				pessoaService.listarCargoDepFed(depFederal, pageable)
				.map(PessoaMapper :: fromEntity));
				}
	
	@GetMapping(value="/deputadosfederal/desc")
	public ResponseEntity<Page<PessoaDTO>>buscaPorDepFederalDesc (@PageableDefault Pageable pageable, String depFederal){
		
		return ResponseEntity.ok(
				pessoaService.listarCargoDepFed(depFederal, pageable)
				.map(PessoaMapper :: fromEntity));
				}
	
	@GetMapping(value="/senadores/asc")
	public ResponseEntity<Page<PessoaDTO>>buscaPorSenadores(@PageableDefault Pageable pageable, String senador){

		return ResponseEntity.ok(
				pessoaService.listarCargoSenador(senador, pageable)
				.map(PessoaMapper :: fromEntity));
				}
	
	@GetMapping(value="/senadores/desc")
	public ResponseEntity<Page<PessoaDTO>>buscaPorSenadoresDesc(@PageableDefault Pageable pageable, String senador){

		return ResponseEntity.ok(
				pessoaService.listarCargoSenadorDesc(senador, pageable)
				.map(PessoaMapper :: fromEntity));
				}
	
	@GetMapping(value="/ministros/asc")
	public ResponseEntity<Page<PessoaDTO>>buscaPorMinistros(@PageableDefault Pageable pageable, String ministro){

		return ResponseEntity.ok(
				pessoaService.listarCargoMinistro(ministro, pageable)
				.map(PessoaMapper :: fromEntity));
				}
	
	@GetMapping(value="/ministros/desc")
	public ResponseEntity<Page<PessoaDTO>>buscaPorMinistrosDesc(@PageableDefault Pageable pageable, String ministro){

		return ResponseEntity.ok(
				pessoaService.listarCargoMinistroDesc(ministro, pageable)
				.map(PessoaMapper :: fromEntity));
				}
	

	@GetMapping(value="/prefeitos/asc")
	public ResponseEntity<Page<PessoaDTO>>buscaPorPrefeitos(@PageableDefault Pageable pageable, String prefeito){

		return ResponseEntity.ok(
				pessoaService.listarCargoPrefeito(prefeito, pageable)
				.map(PessoaMapper :: fromEntity));
	}
	
	@GetMapping(value="/prefeitos/desc")
	public ResponseEntity<Page<PessoaDTO>>buscaPorPrefeitosDesc(@PageableDefault Pageable pageable, String prefeito){

		return ResponseEntity.ok(
				pessoaService.listarCargoPrefeitoDesc(prefeito, pageable)
				.map(PessoaMapper :: fromEntity));
	}
	
	@GetMapping(value="/presidente/asc")
	public ResponseEntity<Page<PessoaDTO>>buscaPorPresidente(@PageableDefault Pageable pageable, String presidente){

		return ResponseEntity.ok(
				pessoaService.listarCargoPresidente(presidente, pageable)
				.map(PessoaMapper :: fromEntity));
	}
	
	
	
	


}
