package Proyecto_Springboot;

import Proyecto_Springboot.Dominios.Actor;
import Proyecto_Springboot.Dominios.Director;
import Proyecto_Springboot.Dominios.Pelicula;
import Proyecto_Springboot.Repositorios.ActorRepository;
import Proyecto_Springboot.Repositorios.DirectorRepository;
import Proyecto_Springboot.Repositorios.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ProyectoSpringbootApplication implements CommandLineRunner {

	@Autowired
	private ActorRepository repository_actor;

	@Autowired
	private DirectorRepository repository_director;

	@Autowired
	private PeliculaRepository repository_pelicula;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoSpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if (repository_pelicula.count() == 0) {

			Director director1 =
					new Director(null, "Christopher Nolan", 53, null);

			Director director2 =
					new Director(null, "Anthony Russo", 54, null);

			Director director3 =
					new Director(null, "Joe Russo", 53, null);

			repository_director.saveAll(
					Arrays.asList(director1, director2, director3)
			);

			Pelicula pelicula1 = new Pelicula();

			pelicula1.setTitulo("Interstellar");
			pelicula1.setGenero("Ciencia ficción");
			pelicula1.setAnio(2014);

			pelicula1.setDirectores(
					Arrays.asList(director1)
			);

			Pelicula pelicula2 = new Pelicula();

			pelicula2.setTitulo("Avengers Endgame");
			pelicula2.setGenero("Acción");
			pelicula2.setAnio(2019);

			pelicula2.setDirectores(
					Arrays.asList(director2, director3)
			);

			repository_pelicula.saveAll(
					Arrays.asList(pelicula1, pelicula2)
			);

			Actor actor1 = new Actor();

			actor1.setNombre("Matthew McConaughey");
			actor1.setNacionalidad("Estadounidense");
			actor1.setPelicula(pelicula1);

			Actor actor2 = new Actor();

			actor2.setNombre("Anne Hathaway");
			actor2.setNacionalidad("Estadounidense");
			actor2.setPelicula(pelicula1);

			Actor actor3 = new Actor();

			actor3.setNombre("Robert Downey Jr.");
			actor3.setNacionalidad("Estadounidense");
			actor3.setPelicula(pelicula2);

			Actor actor4 = new Actor();

			actor4.setNombre("Chris Evans");
			actor4.setNacionalidad("Estadounidense");
			actor4.setPelicula(pelicula2);

			repository_actor.saveAll(
					Arrays.asList(actor1, actor2, actor3, actor4)
			);


		}
	}
}