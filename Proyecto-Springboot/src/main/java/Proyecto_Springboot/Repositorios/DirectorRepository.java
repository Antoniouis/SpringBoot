package Proyecto_Springboot.Repositorios;


import Proyecto_Springboot.Dominios.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
}
