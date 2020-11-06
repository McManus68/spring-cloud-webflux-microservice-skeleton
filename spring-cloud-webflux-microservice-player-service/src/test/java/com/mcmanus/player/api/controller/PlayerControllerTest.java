package com.mcmanus.player.api.controller;

import com.mcmanus.player.api.common.Court;
import com.mcmanus.player.api.common.PlayerResponse;
import com.mcmanus.player.api.model.Player;
import com.mcmanus.player.api.service.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = PlayerController.class)
public class PlayerControllerTest {

    @MockBean
    private PlayerService service;

    @Autowired
    private WebTestClient webClient;

    private Player player;

    @BeforeEach
    private void setUp() {
        player = Player.builder()
                .id(5)
                .name("Manu")
                .mail("mcmanus@aol.fr")
                .favoriteCourt(1)
                .build();
    }

    @Test
    public void should_be_able_to_get_a_player_by_id() {
        Court court = Court.builder().id(1).city("Palavas").build();
        PlayerResponse response = PlayerResponse.builder().player(player).favoriteCourt(court).build();
        when(service.get(1)).thenReturn(Mono.just(response));

        webClient.get()
                .uri("/players/1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(PlayerResponse.class)
                .value(r -> r.getPlayer().getId(), equalTo(5));

    }

    @Test
    public void should_be_able_to_delete_a_player_by_id() {
        webClient.delete()
                .uri("/players/1")
                .exchange()
                .expectStatus().is4xxClientError();

    }

    @Test
    public void should_be_able_to_save_a_player() {
        when(service.save(player)).thenReturn(Mono.just(player));

        webClient.post()
                .uri("/players")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(player), Player.class)
                .exchange()
                .expectStatus().isCreated();
    }

}
