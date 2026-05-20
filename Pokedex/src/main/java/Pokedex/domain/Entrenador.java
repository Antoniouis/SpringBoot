package Pokedex.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="entrenadores")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int edad;
    private int medallas ;
    private int dinero;
    private String region;

}
