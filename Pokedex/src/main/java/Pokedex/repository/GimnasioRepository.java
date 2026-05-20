package Pokedex.repository;

import Pokedex.domain.Gimnasio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GimnasioRepository extends JpaRepository<Gimnasio,Long> {
}
