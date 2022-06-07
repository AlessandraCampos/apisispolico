package gft.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gft.entities.Partido;
import gft.exceptions.EntityNotFoundException;
import gft.repositories.PartidoRepository;


@Service
public class PartidoService {
	
	private final PartidoRepository partidoRepository;
	
	public PartidoService(PartidoRepository partidoRepository) {
		
		this.partidoRepository = partidoRepository;
	}
	
	
	public Page<Partido> buscarPartidos (Pageable pageable){
		
		return partidoRepository.findAll(pageable);
		
	}
	
	public Partido salvarPartido (Partido partido) {
		
		Partido novoPartido =  partidoRepository.save(partido);
		
		return novoPartido;
	}
	
	public Partido buscarPartidoById ( Long id) {
		
		Optional <Partido> partidoId = partidoRepository.findById(id);
		
		return partidoId.orElseThrow(()-> new EntityNotFoundException("Partido não encontrado Id: " + id));
	}
	
	public Partido updatePartido (Partido partido, Long id) {
		Partido partidoId = this.buscarPartidoById(id);
		
		partido.setId(partidoId.getId());
		
		return partidoRepository.save(partido);
		
		
	}
	
	public void  deletePartido ( Long id ) {
		
		partidoRepository.deleteById(id);
	}
	
	
	

}
