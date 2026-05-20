package Proyecto_Springboot.Controladores;

import Proyecto_Springboot.Dominios.Director;
import Proyecto_Springboot.Servicios.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/directores")
@CrossOrigin("*")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    // GET ALL
    @GetMapping
    public List<Director> listar() {
        return directorService.listar();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Director buscarPorId(@PathVariable Long id) {
        return directorService.buscarPorId(id);
    }

    // POST
    @PostMapping
    public Director guardar(@RequestBody Director director) {
        return directorService.guardar(director);
    }

    // PUT
    @PutMapping("/{id}")
    public Director actualizar(@PathVariable Long id,
                               @RequestBody Director director) {

        return directorService.actualizar(id, director);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        directorService.eliminar(id);
    }
}