package Pokedex.service;

import Pokedex.domain.Pokemon;
import Pokedex.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Pokemon> obtenerTodos() {
        return pokemonRepository.findAll();
    }

    public Optional<Pokemon> obtenerPorId(Long id) {
        return pokemonRepository.findById(id);
    }

    public Pokemon guardar(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public Pokemon actualizar(Long id, Pokemon pokemonDetalles) {
        Optional<Pokemon> pokemonOptional = pokemonRepository.findById(id);
        if (pokemonOptional.isPresent()) {
            Pokemon pokemon = pokemonOptional.get();
            pokemon.setNombre(pokemonDetalles.getNombre());
            pokemon.setTipoPrincipal(pokemonDetalles.getTipoPrincipal());
            pokemon.setNivel(pokemonDetalles.getNivel());
            return pokemonRepository.save(pokemon);
        }
        return null;
    }

    public void eliminar(Long id) {
        pokemonRepository.deleteById(id);
    }
}

