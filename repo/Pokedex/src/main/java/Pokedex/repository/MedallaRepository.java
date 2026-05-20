package Pokedex.repository;

import Pokedex.domain.Medalla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedallaRepository extends JpaRepository<Medalla,Long> {

}
