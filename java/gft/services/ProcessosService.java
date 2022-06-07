package gft.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gft.entities.Processos;
import gft.exceptions.EntityNotFoundException;
import gft.repositories.ProcessosRepository;

@Service
public class ProcessosService {
	
	private final ProcessosRepository processosRepository;
	
	public ProcessosService (ProcessosRepository processosRepository) {
		this.processosRepository = processosRepository;
	}

	
	public Page<Processos> listarProcessos (Pageable pageable){
		
		return processosRepository.findAll(pageable);
		
	}
	
	public Processos salvarProcesso (Processos processos) {
		
		return processosRepository.save(processos);
	}
	
	public Processos buscarProcessoPorId ( Long id) {
		
		Optional<Processos> processoId =  processosRepository.findById(id);
		
		return processoId.orElseThrow(()-> new EntityNotFoundException("Processo não encontrado Id: " + id));
	}
	
	public Processos atualizarProcesso(Processos processos, Long id) {
		
		Processos processoId = this.buscarProcessoPorId(id);
		
		processoId.setId(processos.getId());
		
		return processosRepository.save(processos);
	}
	
	
	public void deleteProcesso  ( Long id) {
		processosRepository.deleteById(id);
	}
}
