package com.mcmanus.ps.api.controller;

import com.mcmanus.ps.api.model.Player;
import com.mcmanus.ps.api.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @PostMapping
    public Player save(@RequestBody Player player) {
        return service.save(player);
    }

    @PutMapping
    public Player update(@RequestBody Player player) {
        return service.save(player);
    }

    @GetMapping("/{id}")
    public Player get(@PathVariable int id) {
        return service.get(id);
    }

    @GetMapping
    public List<Player> getAll() {
        return service.getAll();
    }

    @DeleteMapping
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

}
