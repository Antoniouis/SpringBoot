package Proyecto_Springboot.Repositorios;

import Proyecto_Springboot.Dominios.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
}
