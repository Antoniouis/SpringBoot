package Proyecto_Springboot.Controladores;

import Proyecto_Springboot.Dominios.Pelicula;
import Proyecto_Springboot.Servicios.PeliculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
@CrossOrigin("*")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    // GET ALL
    @GetMapping
    public List<Pelicula> listar() {
        return peliculaService.listar();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Pelicula buscarPorId(@PathVariable Long id) {
        return peliculaService.buscarPorId(id);
    }

    // POST
    @PostMapping
    public Pelicula guardar(@Valid @RequestBody Pelicula pelicula) {
        return peliculaService.guardar(pelicula);
    }

    // PUT
    @PutMapping("/{id}")
    public Pelicula actualizar(@PathVariable Long id,
                               @Valid @RequestBody Pelicula pelicula) {

        return peliculaService.actualizar(id, pelicula);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        peliculaService.eliminar(id);
    }
}
