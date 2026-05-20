package Proyecto_Springboot.Servicios;

import Proyecto_Springboot.Dominios.Director;
import Proyecto_Springboot.Repositorios.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    // LISTAR
    public List<Director> listar() {
        return directorRepository.findAll();
    }

    // GUARDAR
    public Director guardar(Director director) {
        return directorRepository.save(director);
    }

    // BUSCAR POR ID
    public Director buscarPorId(Long id) {
        return directorRepository.findById(id).orElse(null);
    }

    // ACTUALIZAR
    public Director actualizar(Long id, Director director) {

        Director directorExistente =
                directorRepository.findById(id).orElse(null);

        if (directorExistente != null) {

            directorExistente.setNombre(director.getNombre());
            directorExistente.setEdad(director.getEdad());

            return directorRepository.save(directorExistente);
        }

        return null;
    }

    // ELIMINAR
    public void eliminar(Long id) {
        directorRepository.deleteById(id);
    }
}
