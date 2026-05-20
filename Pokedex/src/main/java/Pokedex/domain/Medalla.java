package Pokedex.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "medallas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medalla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreMedalla;
    private String liderGimnasio;
    private int medallasObtenidas;

}