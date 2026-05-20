package Pokedex.controller;

import Pokedex.domain.Gimnasio;
import Pokedex.service.GimnasioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pokedex/gimnasio")
public class GimnasioController {

    @Autowired
    private GimnasioService gimnasioService;

    // CREAR
    @PostMapping("/crear")
    public Gimnasio crearGimnasio(@RequestBody Gimnasio gimnasio) {
        return gimnasioService.guardar(gimnasio);
    }

    // LEER
    @GetMapping("/listar")
    public List<Gimnasio> obtenerGimnasio() {

        System.out.println("EL CLIENTE HA ENTRADO EN LA SECCION DE GIMNASIO");

        return gimnasioService.obtenerTodos();
    }

    // LEER POR ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<Gimnasio> obtenerGimnasioPorId(@PathVariable Long id) {

        Optional<Gimnasio> gimnasio = gimnasioService.obtenerPorId(id);

        return gimnasio
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ACTUALIZAR
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Gimnasio> actualizarGimnasio(
            @PathVariable Long id,
            @RequestBody Gimnasio gimnasioDetalles) {

        Gimnasio actualizado = gimnasioService.actualizar(id, gimnasioDetalles);

        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        }

        return ResponseEntity.notFound().build();
    }

    // BORRAR
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> eliminarGimnasio(@PathVariable Long id) {

        gimnasioService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}