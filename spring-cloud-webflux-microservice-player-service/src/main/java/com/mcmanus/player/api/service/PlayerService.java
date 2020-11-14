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


public interface PlayerService {

    Mono<Player> save(Player player);

    Mono<Player> update(Player player);

    Mono<PlayerResponse> get(int id);

    Flux<Player> getAll();

    void delete(int id);
}
