package com.mcmanus.court.api.service;

import com.mcmanus.court.api.model.Court;
import com.mcmanus.court.api.persistence.CourtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourtService {

    Mono<Court> save(Court court);

    Mono<Court> update(Court court);

    Mono<Court> get(int id);

    Flux<Court> getAll();

    void delete(int id);
}
