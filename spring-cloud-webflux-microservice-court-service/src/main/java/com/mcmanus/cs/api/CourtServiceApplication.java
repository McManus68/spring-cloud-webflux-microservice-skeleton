package com.mcmanus.cs.api;

import com.mcmanus.cs.api.model.Court;
import com.mcmanus.cs.api.persistence.CourtRepository;
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
public class CourtServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourtServiceApplication.class, args);
	}

	@Bean
	ApplicationRunner init(CourtRepository repository, DatabaseClient client) {
		return args -> {
			client.execute("create table IF NOT EXISTS COURT" +
					"(id SERIAL PRIMARY KEY," +
					" name varchar (255) not null, " +
					" city varchar (255) not null, " +
					" latitude double not null, " +
					" longitude double (255) not null);").fetch().first().subscribe();

			client.execute("DELETE FROM COURT;").fetch().first().subscribe();

			Stream<Court> stream = Stream.of(
					Court.builder().name("TC Palavas").city("Palavas").latitude(34.67)
							.longitude(12.45).build(),
					Court.builder().name("Mauguio Padel Club").city("Mauguio").latitude(12.32)
							.longitude(43.34).build());

			// initialize the database
			repository.saveAll(Flux.fromStream(stream))
					.then()
					.subscribe(); // execute

		};
	}
}
