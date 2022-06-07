package gft.services;

import java.util.Optional;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import gft.entities.Usuario;
import gft.repositories.UsuarioRepository;




@Service
public class UsuarioService implements UserDetailsService{

	public final UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public Usuario finduserByUsername( String username) {
		
		Optional<Usuario> optional = usuarioRepository.findByUsername(username);
		
		if( optional.isEmpty()) {
			throw new UsernameNotFoundException ("Usuário não encontrado");
		}
		
		return optional.get();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		return finduserByUsername(username);
	}

	public Usuario finduserById(Long idUsuario) {
		Optional<Usuario> optional  = usuarioRepository.findById(idUsuario);
		
		if(optional.isEmpty()) {
			throw new RuntimeException("Usuario nao encontrado");
		}
		return optional.get();
	}

	public Usuario salvarUsuario(Usuario usuario) {
		
		return usuarioRepository.save(usuario);
	}
	
	
	

}
