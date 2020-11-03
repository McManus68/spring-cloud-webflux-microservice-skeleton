package com.mcmanus.ps.api.controller;

import com.mcmanus.ps.api.model.Player;
import com.mcmanus.ps.api.service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/players")
@Api(tags = {"Player API reference documentation."})
public class PlayerController {

    @Autowired
    private PlayerService service;

    @PostMapping
    @ApiOperation("Insert a new player into database")
    public Mono<Player> save(@RequestBody Player player) {
        return service.save(player);
    }

    @PutMapping
    @ApiOperation("Update an existing player into database")
    public Mono<Player> update(@RequestBody Player player) {
        return service.save(player);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve the player with the specified identifier")
    public Mono<Player> get(@PathVariable int id) {
        return service.get(id);
    }

    @GetMapping
    @ApiOperation("Retrieve all players")
    public Flux<Player> getAll() {
        return service.getAll();
    }

    @DeleteMapping
    @ApiOperation("Delete the player with the specified identifier")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

}
