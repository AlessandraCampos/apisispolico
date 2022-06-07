package gft.dto;

import gft.entities.Pessoa;

public class PessoaMapper {

	public static Pessoa fromDTO(PessoaDTO dto) {

		Pessoa pessoa = new Pessoa(null, dto.getNome(),dto.getCpf(),dto.getEndereco(),dto.getTelefone(),dto.getPartido(),dto.getCargo(),dto.getFoto(),dto.getAtribuicao());
		return pessoa;
	}
	
//EnderecoMapper.fromDTO(dto.getEnderecoDto())

	public static PessoaDTO fromEntity(Pessoa pessoa) {
		return new PessoaDTO(pessoa.getId(),pessoa.getNome(),pessoa.getCpf(),pessoa.getEndereco(),
				pessoa.getTelefone(),pessoa.getPartido(),pessoa.getCargo(),pessoa.getFoto(),pessoa.getAtribuicao());
				
	}
	
	
//EnderecoMapper.fromEntity(pessoa.getEndereco())
}



