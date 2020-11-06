package com.mcmanus.player.api.config;

import com.mcmanus.player.api.model.Player;
import com.mcmanus.player.api.persistence.PlayerRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

@Configuration
public class DatabaseConfig {

    @Bean
    ApplicationRunner init(PlayerRepository repository, DatabaseClient client) {
        return args -> {
            client.execute("create table IF NOT EXISTS PLAYER" +
                    "(id SERIAL PRIMARY KEY," +
                    " name varchar (255) not null, " +
                    " mail varchar (255) not null, " +
                    " favorite_court int default false, "+
                    "level int default false);").fetch().first().subscribe();

            client.execute("DELETE FROM PLAYER;").fetch().first().subscribe();

            Stream<Player> stream = Stream.of(
                    Player.builder().name("Manu").mail("manu@aol.fr").level(3).favoriteCourt(1).build(),
                    Player.builder().name("Robert").mail("robert@aol.fr").level(8).favoriteCourt(1).build(),
                    Player.builder().name("Jean").mail("jean@aol.fr").level(4).favoriteCourt(1).build());

            // initialize the database
            repository.saveAll(Flux.fromStream(stream))
                    .then()
                    .subscribe(); // execute

        };
    }
}
