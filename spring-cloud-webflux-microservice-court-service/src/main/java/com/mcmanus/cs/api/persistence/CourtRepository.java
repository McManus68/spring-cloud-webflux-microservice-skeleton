package com.mcmanus.cs.api.persistence;

import com.mcmanus.cs.api.model.Court;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourtRepository extends ReactiveCrudRepository<Court, Integer> {
}
