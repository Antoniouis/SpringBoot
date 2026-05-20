package Pokedex.controller;

import Pokedex.domain.Medalla;
import Pokedex.service.MedallaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pokedex/medallas")
public class MedallaController {

    @Autowired
    private MedallaService medallaService;

    // CREAR
    @PostMapping("/crear")
    public Medalla crearMedalla(@RequestBody Medalla medalla) {
        return medallaService.guardar(medalla);
    }

    // LEER
    @GetMapping("/listar")
    public List<Medalla> obtenerMedallas() {

        System.out.println("EL CLIENTE HA ENTRADO EN LA SECCION DE MEDALLAS");

        return medallaService.obtenerTodos();
    }

    // LEER POR ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<Medalla> obtenerMedallaPorId(@PathVariable Long id) {

        Optional<Medalla> medalla = medallaService.obtenerPorId(id);

        return medalla
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ACTUALIZAR
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Medalla> actualizarMedalla(
            @PathVariable Long id,
            @RequestBody Medalla medallaDetalles) {

        Medalla actualizado = medallaService.actualizar(id, medallaDetalles);

        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        }

        return ResponseEntity.notFound().build();
    }

    // BORRAR
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> eliminarMedalla(@PathVariable Long id) {

        medallaService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}