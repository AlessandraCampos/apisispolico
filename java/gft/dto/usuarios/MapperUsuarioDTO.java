package gft.dto.usuarios;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import gft.entities.Perfil;
import gft.entities.Usuario;

public class MapperUsuarioDTO {


		 public static Usuario fromDTO(RegistroUsuarioDTO dto ) {
			 Perfil perfil = new Perfil();
			 perfil.setId(dto.getPerfilId());
			 
			 
			 return new Usuario(null,dto.getUsername(),new BCryptPasswordEncoder().encode(dto.getSenha()),perfil);
		 }
		
		
		 public static ConsultaUsuariosDTO fromEntity(Usuario usuario ) {
			 
			 return new ConsultaUsuariosDTO(usuario.getUsername(),usuario.getPerfil().getNome());
			 
			 
		 }
	}



