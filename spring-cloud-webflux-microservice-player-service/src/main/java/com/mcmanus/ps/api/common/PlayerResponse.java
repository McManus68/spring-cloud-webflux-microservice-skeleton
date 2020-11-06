package com.mcmanus.ps.api.common;

import com.mcmanus.ps.api.model.Player;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerResponse {

    private Player player;
    private Court favoriteCourt;
}
