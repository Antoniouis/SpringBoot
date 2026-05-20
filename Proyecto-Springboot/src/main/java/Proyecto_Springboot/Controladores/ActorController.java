package Proyecto_Springboot.Controladores;

import Proyecto_Springboot.Dominios.Actor;
import Proyecto_Springboot.Servicios.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actores")
@CrossOrigin("*")
public class ActorController {

    @Autowired
    private ActorService actorService;

    // GET ALL
    @GetMapping
    public List<Actor> listar() {
        return actorService.listar();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Actor buscarPorId(@PathVariable Long id) {
        return actorService.buscarPorId(id);
    }

    // POST
    @PostMapping
    public Actor guardar(@RequestBody Actor actor) {
        return actorService.guardar(actor);
    }

    // PUT
    @PutMapping("/{id}")
    public Actor actualizar(@PathVariable Long id,
                            @RequestBody Actor actor) {

        return actorService.actualizar(id, actor);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        actorService.eliminar(id);
    }
}