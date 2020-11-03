package com.mcmanus.ps.api;

import com.mcmanus.ps.api.model.Player;
import com.mcmanus.ps.api.persistence.PlayerRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

@SpringBootApplication
@EnableEurekaClient
public class PlayerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayerServiceApplication.class, args);
	}

	@Bean
	ApplicationRunner init(PlayerRepository repository, DatabaseClient client) {
		return args -> {
			client.execute("create table IF NOT EXISTS PLAYER" +
					"(id SERIAL PRIMARY KEY," +
					" name varchar (255) not null, " +
					" mail varchar (255) not null, " +
					 "level int default false);").fetch().first().subscribe();

			client.execute("DELETE FROM PLAYER;").fetch().first().subscribe();

			Stream<Player> stream = Stream.of(
					new Player(null, "Manu", "manu@aol.fr", 3),
					new Player(null, "Robert", "robert@aol.fr", 8),
					new Player(null, "Jean", "jean@aol.fr", 4));

			// initialize the database
			repository.saveAll(Flux.fromStream(stream))
					.then()
					.subscribe(); // execute

		};
	}
}
