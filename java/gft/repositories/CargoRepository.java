package gft.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gft.entities.Cargo;

@Repository
public interface CargoRepository  extends JpaRepository < Cargo, Long> {

	Page<Cargo> findAll(Pageable pageable);

}
