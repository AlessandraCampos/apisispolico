package gft.dto.usuarios;

public class RegistroUsuarioDTO {
	
	private String username;
	private String senha;
	private Long perfilId;
	
	public RegistroUsuarioDTO(String username, String senha, Long perfilId) {
		this.username = username;
		this.senha = senha;
		this.perfilId = perfilId;
	}

	public RegistroUsuarioDTO() {
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getPerfilId() {
		return perfilId;
	}

	public void setPerfilId(Long perfilId) {
		this.perfilId = perfilId;
	}
	

}
