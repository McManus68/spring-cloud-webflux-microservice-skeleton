package com.mcmanus.ps.api.service;

import com.mcmanus.ps.api.model.Player;
import com.mcmanus.ps.api.persistence.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    public Mono<Player> save(Player player) {
        return repository.save(player);
    }

    public Mono<Player> update(Player player) {
        return repository.save(player);
    }

    public Mono<Player> get(int id) {
        return repository.findById(id);
    }

    public Flux<Player> getAll() {
        return repository.findAll();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
