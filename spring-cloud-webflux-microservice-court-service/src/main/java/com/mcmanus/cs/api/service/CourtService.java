package com.mcmanus.cs.api.service;

import com.mcmanus.cs.api.model.Court;
import com.mcmanus.cs.api.persistence.CourtRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class CourtService {

    @Autowired
    private CourtRepository repository;

    public Mono<Court> save(Court court) {
        return repository.save(court);
    }

    public Mono<Court> update(Court court) {
        return repository.save(court);
    }

    public Mono<Court> get(int id) {
        return repository.findById(id);
    }

    public Flux<Court> getAll() {
        return repository.findAll();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
