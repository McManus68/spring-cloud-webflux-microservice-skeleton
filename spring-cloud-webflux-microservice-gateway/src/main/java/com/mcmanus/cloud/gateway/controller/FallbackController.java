package com.mcmanus.cloud.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @RequestMapping("playerFallBack")
    public Mono<String> playerServiceFallBack() {
        return Mono.just("Payment service is taking too long to respond or is down. Please try again later");
    }
}
