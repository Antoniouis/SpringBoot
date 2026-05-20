package Pokedex.service;

import Pokedex.domain.Entrenador;
import Pokedex.domain.Pokemon;
import Pokedex.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorService {
    @Autowired
    private EntrenadorRepository entrenadorRepository;

    public List<Entrenador> obtenerTodos() {
        return entrenadorRepository.findAll();
    }

    public Optional<Entrenador> obtenerPorId(Long id) {
        return entrenadorRepository.findById(id);
    }

    public Entrenador guardar(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public Entrenador actualizar(Long id, Entrenador entrenadorDetalles) {

        Optional<Entrenador> entrenadorOptional = entrenadorRepository.findById(id);

        if (entrenadorOptional.isPresent()) {

            Entrenador entrenador = entrenadorOptional.get();

            entrenador.setNombre(entrenadorDetalles.getNombre());
            entrenador.setEdad(entrenadorDetalles.getEdad());
            entrenador.setRegion(entrenadorDetalles.getRegion());
            entrenador.setMedallas(entrenadorDetalles.getMedallas());

            return entrenadorRepository.save(entrenador);
        }

        return null;
    }

    public void eliminar(Long id) {
        entrenadorRepository.deleteById(id);
    }
}
