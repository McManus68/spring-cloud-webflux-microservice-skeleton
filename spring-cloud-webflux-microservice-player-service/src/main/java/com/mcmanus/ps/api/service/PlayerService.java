package com.mcmanus.ps.api.service;

import com.mcmanus.ps.api.model.Player;
import com.mcmanus.ps.api.persistence.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@Slf4j
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    public Player save(Player player) {
        return repository.save(player);
    }

    public Player update(Player player) {
        return repository.save(player);
    }

    public Player get(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Player> getAll() {
        return repository.findAll();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
