package Pokedex.service;

import Pokedex.domain.Gimnasio;
import Pokedex.domain.Pokemon;
import Pokedex.repository.GimnasioRepository;
import Pokedex.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GimnasioService {

    @Autowired
    private GimnasioRepository gimnasioRepository;

    public List<Gimnasio> obtenerTodos() {
        return gimnasioRepository.findAll();
    }

    public Optional<Gimnasio> obtenerPorId(Long id) {
        return gimnasioRepository.findById(id);
    }

    public Gimnasio guardar(Gimnasio gimnasio) {
        return gimnasioRepository.save(gimnasio);
    }

    public Gimnasio actualizar(Long id, Gimnasio gimnasioDetalles) {

        Optional<Gimnasio> gimnasioOptional = gimnasioRepository.findById(id);
        if (gimnasioOptional.isPresent()) {

            Gimnasio gimnasio = gimnasioOptional.get();

            gimnasio.setNombre(gimnasioDetalles.getNombre());
            gimnasio.setTipo(gimnasioDetalles.getTipo());
            gimnasio.setMedalla(gimnasioDetalles.getMedalla());
            gimnasio.setCiudad(gimnasioDetalles.getCiudad());
            gimnasio.setNivelDificultad(gimnasioDetalles.getNivelDificultad());




            return gimnasioRepository.save(gimnasio);
        }
        return null;
    }

    public void eliminar(Long id) {
        gimnasioRepository.deleteById(id);
    }
}
