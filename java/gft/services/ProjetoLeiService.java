package gft.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import gft.entities.ProjetosLei;
import gft.exceptions.EntityNotFoundException;
import gft.repositories.ProjetoLeiRepository;

@Service
public class ProjetoLeiService {
	
	private final ProjetoLeiRepository projetoLeiRepository;
	
	public ProjetoLeiService (ProjetoLeiRepository projetoLeiRepository) {
	this.projetoLeiRepository = projetoLeiRepository;	
	}
	
	
	public Page<ProjetosLei> ListarProjetosLei (Pageable pageable){
		
		return projetoLeiRepository.findAll(pageable);
	}
	
	 public ProjetosLei salvarProjeto ( ProjetosLei projetosLei) {
	        ProjetosLei projetos = projetoLeiRepository.save(projetosLei);
	        
	 return projetos;
		 
	 }
	 
	 
	 public ProjetosLei buscarProjetoPorId ( Long id) {
		 
		 Optional<ProjetosLei> projetosId = projetoLeiRepository.findById(id);
		 return projetosId.orElseThrow(()-> new EntityNotFoundException("Projeto de Lei não encontrado Id: " + id));
		 
	 }

	 
	 public void deleteProjeto ( Long id) {
		 
     projetoLeiRepository.deleteById(id);
	 }
	 
	 
	 public ProjetosLei atualizarProjetoLei(ProjetosLei projetosLei ,  Long id) {
		 
		 ProjetosLei projeto = this.buscarProjetoPorId(id);
		 
		 projeto.setId(projetosLei.getId());
		 
		 return projetoLeiRepository.save(projeto);
		 
		 
	 }
	 
}
