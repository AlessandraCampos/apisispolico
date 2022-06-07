package gft.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import gft.entities.Endereco;
import gft.exceptions.EntityNotFoundException;
import gft.repositories.EnderecoRepository;


@Service
public class EnderecoService {
	
	private EnderecoRepository enderecoRepository;
	public EnderecoService(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
		
	}
	
	public  List<Endereco> buscarEnderecos(){
		
	return	enderecoRepository.findAll();
		
	}
	
	public Endereco salvarEndereco( Endereco endereco) {
		
		return enderecoRepository.save(endereco);
	}
	
	
	public Endereco buscarEnderecoPorId( Long id) {
		
		Optional <Endereco> endId = enderecoRepository.findById(id);
		
		return endId.orElseThrow(()-> new EntityNotFoundException("Endereço não encontrado  Id: " + id));
		
	}
	
	
	public Endereco alterarEndereco (Endereco endereco , Long id ) {
		
		Endereco endId = this.buscarEnderecoPorId(id);
		
		endId.setId(endereco.getId());
	
		return enderecoRepository.save(endereco);
	}
	
	
	public void excluirEndereco ( Long id) {
		
		enderecoRepository.deleteById(id);	
	}

}
