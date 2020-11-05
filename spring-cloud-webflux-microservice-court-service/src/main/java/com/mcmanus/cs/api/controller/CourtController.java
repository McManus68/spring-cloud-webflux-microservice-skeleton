package com.mcmanus.cs.api.controller;

import com.mcmanus.cs.api.model.Court;
import com.mcmanus.cs.api.service.CourtService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/courts")
@Api(tags = {"Court API reference documentation."})
public class CourtController {

    @Autowired
    private CourtService service;

    @PostMapping
    @ApiOperation("Insert a new court into database")
    public Mono<Court> save(@RequestBody Court court) {
        return service.save(court);
    }

    @PutMapping
    @ApiOperation("Update an existing court into database")
    public Mono<Court> update(@RequestBody Court court) {
        return service.save(court);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve the court with the specified identifier")
    public Mono<Court> get(@PathVariable int id) {
        return service.get(id);
    }

    @GetMapping
    @ApiOperation("Retrieve all courts")
    public Flux<Court> getAll() {
        return service.getAll();
    }

    @DeleteMapping
    @ApiOperation("Delete the court with the specified identifier")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

}
