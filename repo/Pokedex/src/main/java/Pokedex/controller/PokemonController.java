package Pokedex.controller;

import Pokedex.domain.Pokemon;
import Pokedex.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pokedex/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    // CREAR
    @PostMapping("/crear")
    public Pokemon crearPokemon(@RequestBody Pokemon pokemon) {
        return pokemonService.guardar(pokemon);
    }

    // LEER
    @GetMapping("/listar")
    public List<Pokemon> obtenerPokemons() {

        System.out.println("EL CLIENTE HA ENTRADO EN LA SECCION DE POKEMON");

        return pokemonService.obtenerTodos();
    }

    // LEER POR ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<Pokemon> obtenerPokemonPorId(@PathVariable Long id) {

        Optional<Pokemon> pokemon = pokemonService.obtenerPorId(id);

        return pokemon
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ACTUALIZAR
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Pokemon> actualizarPokemon(
            @PathVariable Long id,
            @RequestBody Pokemon pokemonDetalles) {

        Pokemon actualizado = pokemonService.actualizar(id, pokemonDetalles);

        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        }

        return ResponseEntity.notFound().build();
    }

    // BORRAR
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> eliminarPokemon(@PathVariable Long id) {

        pokemonService.eliminar(id);

        return ResponseEntity.noContent().build();
    }


}
