package gft.controllers;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gft.dto.TokenDTO;
import gft.security.AutenticacaoForm;
import gft.services.AutenticacaoService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
	
	
	@PostMapping
	public ResponseEntity<TokenDTO> autenticar(@RequestBody AutenticacaoForm authForm) throws AuthenticationException{
		
		return ResponseEntity.ok(autenticacaoService.autenticar(authForm));
		
		
	}

}
