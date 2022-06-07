
package gft.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import gft.entities.Pessoa;
import gft.exceptions.EntityNotFoundException;
import gft.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	private PessoaRepository pessoaRepository;	
	
	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
		
	}
	
	
	public List<Pessoa> listarPessoas() {
		
		return pessoaRepository.findAll();
	}
	
	
	public Page<Pessoa> listarCargoVereador(String vereador, Pageable pageable) {
		
		return (Page<Pessoa>) pessoaRepository.findByVereador(vereador, pageable);
	}
	
   public Page<Pessoa> listarCargoVereadorDesc(String vereador, Pageable pageable) {
		
		return (Page<Pessoa>) pessoaRepository.findByVereadorDesc(vereador, pageable);
			
	}
	
   
   public Page<Pessoa> listarCargoGovernador(String governador,Pageable pageable) {
	   return (Page<Pessoa>) pessoaRepository.findByGovernador(governador, pageable);
   
   }
   
   
   public Page<Pessoa> listarCargoGovernadorDesc(String governador,Pageable pageable) {
	   return (Page<Pessoa>) pessoaRepository.findByGovernadorDesc(governador, pageable);
   
   }
   
   public Page<Pessoa> listarCargoDepEst(String depEstadual,Pageable pageable) {
	   return (Page<Pessoa>) pessoaRepository.findByDepEst(depEstadual, pageable);
   
   }
   
   public Page<Pessoa> listarCargoDepEstDesc(String depEstadual,Pageable pageable) {
	   return (Page<Pessoa>) pessoaRepository.findByDepEstDesc(depEstadual, pageable);
			 
   
   }
   
   
   public Page<Pessoa> listarCargoDepFed (String depFederal,Pageable pageable) {
	   return (Page<Pessoa>) pessoaRepository.findByDepFed(depFederal, pageable);
   }
   
   
   
   public Page<Pessoa> listarCargoDepFedDesc(String depFederal,Pageable pageable) {
	   return (Page<Pessoa>) pessoaRepository.findByDepFedDesc(depFederal, pageable);
			
			 
   
   }
   
   public Page<Pessoa> listarCargoSenador(String senador,Pageable pageable) {
	   return (Page<Pessoa>) pessoaRepository.findBySenador(senador, pageable);
   }
   
   public Page<Pessoa> listarCargoSenadorDesc(String senador,Pageable pageable) {
	   return (Page<Pessoa>) pessoaRepository.findBySenadorDesc(senador, pageable);
			
   }
   
   public Page<Pessoa> listarCargoMinistro(String ministro,Pageable pageable) {
	   return (Page<Pessoa>) pessoaRepository.findByMinistro(ministro, pageable);
			
   }
   
   public Page<Pessoa> listarCargoMinistroDesc(String ministro,Pageable pageable) {
	   return (Page<Pessoa>) pessoaRepository.findByMinistroDesc(ministro, pageable);	 
			
   }
   
   public Page<Pessoa> listarCargoPrefeito(String prefeito,Pageable pageable) {
	   return (Page<Pessoa>) pessoaRepository.findByPrefeito(prefeito, pageable);
			 
			
   }
   public Page<Pessoa> listarCargoPrefeitoDesc(String prefeito,Pageable pageable) {
	   return (Page<Pessoa>) pessoaRepository.findByPrefeitoDesc(prefeito, pageable);
			 
			
   }
   
   public Page<Pessoa> listarCargoPresidente(String presidente,Pageable pageable) {
	   return (Page<Pessoa>) pessoaRepository.findByPresidente(presidente, pageable);
			 
			
   }
   
   
	public Pessoa salvarPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	
	
	
	
	
	public Pessoa buscarPorId(Long id) {
		
		Optional<Pessoa> pessoaId = pessoaRepository.findById(id);
		return pessoaId.orElseThrow(()-> new EntityNotFoundException("Político não encontrado  Id: " + id));
	}
	
	public Pessoa atualizarPessoa (Pessoa pessoa , Long id ) {
		Pessoa pessoaAtual = this.buscarPorId(id);
		
		pessoa.setId(pessoaAtual.getId());
		
		
		return pessoaRepository.save(pessoa);
		
	}
	
	public void excluirPolitico(Long id ) {
		pessoaRepository.deleteById(id);
	}

}
