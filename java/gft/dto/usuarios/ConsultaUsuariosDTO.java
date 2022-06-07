package gft.dto.usuarios;

public class ConsultaUsuariosDTO {
	
	private String username;
	private String nomePerfil;
	
	
	
	public ConsultaUsuariosDTO() {
	}
	public ConsultaUsuariosDTO(String username, String nomePerfil) {
		this.username = username;
		this.nomePerfil = nomePerfil;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNomePerfil() {
		return nomePerfil;
	}
	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}

}


