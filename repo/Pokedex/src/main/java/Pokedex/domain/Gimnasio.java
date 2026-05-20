package Pokedex.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="gimnasios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gimnasio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String nombre;
    private String ciudad;
    private String tipo ;
    private String medalla ;
    private int nivelDificultad;
}
