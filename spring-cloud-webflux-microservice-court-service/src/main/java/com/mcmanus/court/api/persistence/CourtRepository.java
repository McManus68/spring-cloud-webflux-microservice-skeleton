package com.mcmanus.court.api.persistence;

import com.mcmanus.court.api.model.Court;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourtRepository extends ReactiveCrudRepository<Court, Integer> {
}
