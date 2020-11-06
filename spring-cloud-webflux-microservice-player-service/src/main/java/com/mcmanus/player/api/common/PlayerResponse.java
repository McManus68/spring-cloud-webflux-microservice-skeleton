package com.mcmanus.player.api.common;

import com.mcmanus.player.api.model.Player;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerResponse {

    private Player player;
    private Court favoriteCourt;
}
