package gft.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gft.dto.usuarios.ConsultaUsuariosDTO;
import gft.dto.usuarios.MapperUsuarioDTO;
import gft.dto.usuarios.RegistroUsuarioDTO;
import gft.entities.Usuario;
import gft.services.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
private final UsuarioService usuarioService;
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
		
	}
	@PostMapping
	public ResponseEntity<ConsultaUsuariosDTO> salvarUsuario(@RequestBody RegistroUsuarioDTO usuarioDto){
			
			Usuario usuario = usuarioService.salvarUsuario(MapperUsuarioDTO.fromDTO(usuarioDto));
			
			return ResponseEntity.ok(MapperUsuarioDTO.fromEntity(usuario));
			
	}
}
