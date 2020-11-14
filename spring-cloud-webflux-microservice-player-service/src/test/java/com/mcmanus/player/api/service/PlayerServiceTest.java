package com.mcmanus.player.api.service;

import com.mcmanus.player.api.common.Court;
import com.mcmanus.player.api.common.PlayerResponse;
import com.mcmanus.player.api.model.Player;
import com.mcmanus.player.api.persistence.PlayerRepository;
import com.mcmanus.player.api.service.impl.PlayerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class PlayerServiceTest {

    @Autowired
    private PlayerService service;

    @MockBean
    private PlayerRepository repository;

    @MockBean
    private RestTemplate template;

    private Player player;

    private Court court;

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public PlayerService playerService() {
            return new PlayerServiceImpl();
        }
    }

    @BeforeEach
    private void setUp() {
        player = Player.builder()
                .id(5)
                .name("Manu")
                .mail("mcmanus@aol.fr")
                .favoriteCourt(1)
                .build();

        court = Court.builder()
                .id(4)
                .city("Paris")
                .name("Paris TC")
                .latitude(12.4)
                .longitude(83.3)
                .build();
    }

    @Test
    public void should_be_able_to_get_a_player_by_id() {
        when(repository.findById(5)).thenReturn(Mono.just(player));
        when(template.getForObject(anyString(), any())).thenReturn(court);

        Mono<PlayerResponse> response = service.get(5);

        StepVerifier.create(response)
                .assertNext(r -> {
                    Assertions.assertEquals(r.getPlayer().getId(), 5);
                    Assertions.assertEquals(r.getFavoriteCourt().getId(), 4);
                })
                .verifyComplete();

    }
}
