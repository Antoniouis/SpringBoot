package Pokedex.service;

import Pokedex.domain.Medalla;
import Pokedex.repository.MedallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedallaService {
    @Autowired
    private MedallaRepository medallaRepository;

    public List<Medalla> obtenerTodos() {
        return medallaRepository.findAll();
    }

    public Optional<Medalla> obtenerPorId(Long id) {
        return medallaRepository.findById(id);
    }

    public Medalla guardar(Medalla medalla) {
        return medallaRepository.save(medalla);
    }

    public Medalla actualizar(Long id, Medalla medallaDetalles) {

        Optional<Medalla> medallaOptional = medallaRepository.findById(id);

        if (medallaOptional.isPresent()) {

            Medalla medalla = medallaOptional.get();

            medalla.setNombreMedalla(medallaDetalles.getNombreMedalla());
            medalla.setLiderGimnasio(medallaDetalles.getLiderGimnasio());
            medalla.setMedallasObtenidas(medallaDetalles.getMedallasObtenidas());

            return medallaRepository.save(medalla);
        }

        return null;
    }

    public void eliminar(Long id) {
        medallaRepository.deleteById(id);
    }
}
