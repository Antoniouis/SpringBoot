package Pokedex;

import Pokedex.domain.Entrenador;
import Pokedex.domain.Gimnasio;
import Pokedex.domain.Medalla;
import Pokedex.domain.Pokemon;
import Pokedex.repository.EntrenadorRepository;
import Pokedex.repository.GimnasioRepository;
import Pokedex.repository.MedallaRepository;
import Pokedex.repository.PokemonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokedexApplication implements CommandLineRunner {

	@Autowired
	private PokemonRepository repository_pokemon;

	@Autowired
	private EntrenadorRepository repository_entrenador;

	@Autowired
	private GimnasioRepository repository_gimnasio;

	@Autowired
	private MedallaRepository repository_medalla;


	public static void main(String[] args) {
		SpringApplication.run(PokedexApplication.class, args);
	}

	@Override
	public void run(String... args) {

		//POKEMONS
		if (repository_pokemon.count() == 0 ) {

			//POKEMON
			repository_pokemon.save(new Pokemon(null, "Pikachu", "Eléctrico", 25));
			repository_pokemon.save(new Pokemon(null, "Charizard", "Fuego", 50));
			repository_pokemon.save(new Pokemon(null, "Blastoise", "Agua", 48));
			repository_pokemon.save(new Pokemon(null, "Venusaur", "Planta", 46));
			repository_pokemon.save(new Pokemon(null, "Gengar", "Fantasma", 40));

			System.out.println("DATOS POKEMONS CARGADOS ");
		} else {System.out.println("LOS DATOS DE POKEMONS YA FUERON CARGADOS EN LA BASE DE DATOS ");}

		//ENTRENEDORES
		if (repository_entrenador.count() == 0 ) {

				repository_entrenador.save(new Entrenador(null, "Ash Ketchum", 15, 8, 5000, "Kanto"));
				repository_entrenador.save(new Entrenador(null, "Misty", 16, 4, 3200, "Kanto"));
				repository_entrenador.save(new Entrenador(null, "Brock", 18, 6, 4100, "Kanto"));
				repository_entrenador.save(new Entrenador(null, "Cynthia", 26, 12, 15000, "Sinnoh"));
				repository_entrenador.save(new Entrenador(null, "Leon", 25, 10, 20000, "Galar"));
				repository_entrenador.save(new Entrenador(null, "Red", 20, 16, 30000, "Kanto"));
				repository_entrenador.save(new Entrenador(null, "Iris", 17, 7, 4800, "Teselia"));
				repository_entrenador.save(new Entrenador(null, "Steven", 28, 11, 18000, "Hoenn"));


				System.out.println("DATOS ENTRENADORES CARGADOS");
		} else {System.out.println("LOS DATOS DE ENTRENADORES YA FUERON CARGADOS EN LA BASE DE DATOS ");}

		//GIMNASIOS
		if(repository_gimnasio.count() == 0 ) {
			repository_gimnasio.save(
					new Gimnasio(null, "Gimnasio Plateada", "Ciudad Plateada", "Roca", "Medalla Roca", 3)
			);

			repository_gimnasio.save(
					new Gimnasio(null, "Gimnasio Celeste", "Ciudad Celeste", "Agua", "Medalla Cascada", 4)
			);

			repository_gimnasio.save(
					new Gimnasio(null, "Gimnasio Carmín", "Ciudad Carmín", "Eléctrico", "Medalla Trueno", 5)
			);

			System.out.println("DATOS GIMNASIOS CARGADOS");
		}else {
			System.out.println("LOS DATOS DE GIMNASIOS YA FUERON CARGADOS EN LA BASE DE DATOS ");
		}

		//MEDALLAS
		if (repository_medalla.count() == 0) {

			repository_medalla.save(new Medalla(null, "Medalla Roca", "Brock", 1));
			repository_medalla.save(new Medalla(null, "Medalla Cascada", "Misty", 2));
			repository_medalla.save(new Medalla(null, "Medalla Trueno", "Lt. Surge", 3));
			repository_medalla.save(new Medalla(null, "Medalla Arcoiris", "Erika", 4));
			repository_medalla.save(new Medalla(null, "Medalla Alma", "Koga", 5));
			repository_medalla.save(new Medalla(null, "Medalla Pantano", "Sabrina", 6));
			repository_medalla.save(new Medalla(null, "Medalla Volcán", "Blaine", 7));
			repository_medalla.save(new Medalla(null, "Medalla Tierra", "Giovanni", 8));

			System.out.println("DATOS MEDALLAS CARGADOS");
		} else {
			System.out.println("LOS DATOS DE MEDALLAS YA FUERON CARGADOS EN LA BASE DE DATOS ");
		}
























	}
}