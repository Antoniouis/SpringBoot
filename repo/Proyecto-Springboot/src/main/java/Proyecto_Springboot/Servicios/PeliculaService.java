package Proyecto_Springboot.Servicios;

import Proyecto_Springboot.Dominios.Pelicula;
import Proyecto_Springboot.Repositorios.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    // LISTAR
    public List<Pelicula> listar() {
        return peliculaRepository.findAll();
    }

    // GUARDAR
    public Pelicula guardar(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    // BUSCAR POR ID
    public Pelicula buscarPorId(Long id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    // ACTUALIZAR
    public Pelicula actualizar(Long id, Pelicula pelicula) {

        Pelicula peliculaExistente =
                peliculaRepository.findById(id).orElse(null);

        if (peliculaExistente != null) {

            peliculaExistente.setTitulo(pelicula.getTitulo());
            peliculaExistente.setGenero(pelicula.getGenero());
            peliculaExistente.setAnio(pelicula.getAnio());
            peliculaExistente.setActores(pelicula.getActores());
            peliculaExistente.setDirectores(pelicula.getDirectores());

            return peliculaRepository.save(peliculaExistente);
        }

        return null;
    }

    // ELIMINAR
    public void eliminar(Long id) {
        peliculaRepository.deleteById(id);
    }
}
