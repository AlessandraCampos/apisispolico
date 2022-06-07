package gft.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gft.entities.ProjetosLei;

@Repository
public interface ProjetoLeiRepository extends JpaRepository <ProjetosLei , Long > {
	
	Page<ProjetosLei> findAll (Pageable pageable);

}
