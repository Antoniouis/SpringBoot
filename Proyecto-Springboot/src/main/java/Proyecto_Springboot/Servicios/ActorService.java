package Proyecto_Springboot.Servicios;

import Proyecto_Springboot.Dominios.Actor;
import Proyecto_Springboot.Repositorios.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    // LISTAR
    public List<Actor> listar() {
        return actorRepository.findAll();
    }

    // GUARDAR
    public Actor guardar(Actor actor) {
        return actorRepository.save(actor);
    }

    // BUSCAR POR ID
    public Actor buscarPorId(Long id) {
        return actorRepository.findById(id).orElse(null);
    }

    // ACTUALIZAR
    public Actor actualizar(Long id, Actor actor) {

        Actor actorExistente =
                actorRepository.findById(id).orElse(null);

        if (actorExistente != null) {

            actorExistente.setNombre(actor.getNombre());
            actorExistente.setNacionalidad(actor.getNacionalidad());
            actorExistente.setPelicula(actor.getPelicula());

            return actorRepository.save(actorExistente);
        }

        return null;
    }

    // ELIMINAR
    public void eliminar(Long id) {
        actorRepository.deleteById(id);
    }
}