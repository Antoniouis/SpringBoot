package Pokedex.controller;

import Pokedex.domain.Entrenador;
import Pokedex.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pokedex/entrenador")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    // CREAR
    @PostMapping("/crear")
    public Entrenador crearEntrenador(@RequestBody Entrenador entrenador) {
        return entrenadorService.guardar(entrenador);
    }

    // LEER
    @GetMapping("/listar")
    public List<Entrenador> obtenerEntrenadores() {

        System.out.println("EL CLIENTE HA ENTRADO EN LA SECCION DE ENTRENADOR");

        return entrenadorService.obtenerTodos();
    }

    // LEER POR ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<Entrenador> obtenerEntrenadorPorId(@PathVariable Long id) {

        Optional<Entrenador> entrenador = entrenadorService.obtenerPorId(id);

        return entrenador
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ACTUALIZAR
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Entrenador> actualizarEntrenador(
            @PathVariable Long id,
            @RequestBody Entrenador entrenadorDetalles) {

        Entrenador actualizado = entrenadorService.actualizar(id, entrenadorDetalles);

        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        }

        return ResponseEntity.notFound().build();
    }

    // BORRAR
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> eliminarEntrenador(@PathVariable Long id) {

        entrenadorService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}