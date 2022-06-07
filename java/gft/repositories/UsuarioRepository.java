package gft.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gft.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long>{
	
    Optional<Usuario> findByUsername(String username);
    Page<Usuario>findAll(Pageable pageable);
}
