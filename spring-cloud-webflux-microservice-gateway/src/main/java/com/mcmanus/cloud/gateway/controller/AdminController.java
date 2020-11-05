package com.mcmanus.cloud.gateway.controller;

import com.okta.sdk.client.Client;
import com.okta.sdk.resource.user.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class AdminController {

    @Autowired
    public Client client;

    @GetMapping("/home")
    public Mono<OAuth2AuthenticationToken> home(Mono<OAuth2AuthenticationToken> token) {
        return token;
    }

    @GetMapping("/users")
    public UserList getUsers() {
        return client.listUsers();
    }
}