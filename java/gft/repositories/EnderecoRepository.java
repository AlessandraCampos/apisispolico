package gft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import gft.entities.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository <Endereco, Long>{

}

