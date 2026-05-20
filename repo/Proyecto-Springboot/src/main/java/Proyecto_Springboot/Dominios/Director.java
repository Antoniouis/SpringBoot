package Proyecto_Springboot.Dominios;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Director {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int edad;

    //Relación
    @ManyToMany(mappedBy = "directores")
    private List<Pelicula> peliculas;
}