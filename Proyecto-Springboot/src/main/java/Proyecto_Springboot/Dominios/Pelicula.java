package Proyecto_Springboot.Dominios;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bd_peliculas")
public class Pelicula {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    @NotBlank(message = "El título no puede estar vacío.")
    private String titulo;
    @NotBlank(message = "Debe tener un género.")
    @Size(min = 2)
    private String genero;
    @Min(1895)
    @Max(2030)
    private int anio;
    //Relaciones
    @OneToMany(mappedBy = "pelicula",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Actor> actores;

    @ManyToMany
    @JoinTable( name = "peliculas_director", joinColumns = @JoinColumn(name = "pelicula_id"), inverseJoinColumns = @JoinColumn(name = "director_id"))
    private List<Director> directores;
    //@Transient
    //private String categoriaVisual;

}
