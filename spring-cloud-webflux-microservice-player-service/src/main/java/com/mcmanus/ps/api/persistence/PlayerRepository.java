package com.mcmanus.ps.api.persistence;

import com.mcmanus.ps.api.model.Player;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends ReactiveCrudRepository<Player, Integer> {
}
