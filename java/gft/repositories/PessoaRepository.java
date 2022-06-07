package gft.repositories;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gft.entities.Pessoa;

@Repository
public interface PessoaRepository extends PagingAndSortingRepository <Pessoa, Long>{
	
	List <Pessoa> findAll ();
	
	@Query("select u from Pessoa u where u.cargo = 1 ORDER BY nome ASC")
	public Page <Pessoa> findByVereador(String vereador,Pageable pageable);	
	
	
	@Query("select u from Pessoa u where u.cargo = 1 ORDER BY u.nome desc")
	public Page <Pessoa> findByVereadorDesc(String vereador,Pageable pageable);	
	
	@Query("select u from Pessoa u where u.cargo = 2 ORDER BY u.nome ASC")
	public Page <Pessoa> findByGovernador(String governador,Pageable pageable);	
	
	@Query("select u from Pessoa u where u.cargo = 2 ORDER BY u.nome desc")
	public Page <Pessoa> findByGovernadorDesc(String governador,Pageable pageable);	
	
	@Query("select u from Pessoa u where u.cargo = 3 ORDER BY u.nome ASC")
	public Page <Pessoa> findByDepEst(String depEstadual,Pageable pageable);	
	
	@Query("select u from Pessoa u where u.cargo = 3 ORDER BY u.nome desc")
	public Page <Pessoa> findByDepEstDesc(String depEstadual,Pageable pageable);	
	
	@Query("select u from Pessoa u where u.cargo = 4 ORDER BY u.nome ASC")
	public Page <Pessoa> findByDepFed(String deputadoFed,Pageable pageable);	
	
	@Query("select u from Pessoa u where u.cargo = 4 ORDER BY u.nome desc")
	public Page <Pessoa> findByDepFedDesc(String deputadoFed,Pageable pageable);
	
	@Query("select u from Pessoa u where u.cargo = 5 ORDER BY u.nome ASC")
	public Page <Pessoa> findBySenador(String senador,Pageable pageable);	
	
	@Query("select u from Pessoa u where u.cargo = 5 ORDER BY u.nome desc")
	public Page <Pessoa> findBySenadorDesc(String senador,Pageable pageable);
	
	@Query("select u from Pessoa u where u.cargo = 6 ORDER BY u.nome ASC")
	public Page <Pessoa> findByMinistro(String ministro,Pageable pageable);	
	
	@Query("select u from Pessoa u where u.cargo = 6 ORDER BY u.nome desc")
	public Page <Pessoa> findByMinistroDesc(String ministro,Pageable pageable);
	
	@Query("select u from Pessoa u where u.cargo = 7 ORDER BY u.nome ASC")
	public Page <Pessoa> findByPrefeito(String prefeito,Pageable pageable);	
	
	@Query("select u from Pessoa u where u.cargo = 7 ORDER BY u.nome desc")
	public Page <Pessoa> findByPrefeitoDesc(String prefeito,Pageable pageable);
	
	@Query("select u from Pessoa u where u.cargo = 8 ORDER BY u.nome ASC")
	public Page <Pessoa> findByPresidente(String presidente,Pageable pageable);	
	
	
}
