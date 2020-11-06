package com.mcmanus.player.api.service;

import com.mcmanus.player.api.common.Court;
import com.mcmanus.player.api.model.Player;
import com.mcmanus.player.api.persistence.PlayerRepository;
import com.mcmanus.player.api.common.PlayerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    @Autowired
    @Lazy
    private RestTemplate template;

    @Value("${microservice.court-service.uri}")
    private String COURT_URL;

    public Mono<Player> save(Player player) {
        return repository.save(player);
    }

    public Mono<Player> update(Player player) {
        return repository.save(player);
    }

    public Mono<PlayerResponse> get(int id) {
        Court court = template.getForObject(COURT_URL + "/1", Court.class);
        log.info("favorite court = " + court.getName());

        return repository.findById(id)
                .map(player -> PlayerResponse.builder().player(player).favoriteCourt(court).build());
    }

    public Flux<Player> getAll() {
        return repository.findAll();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
