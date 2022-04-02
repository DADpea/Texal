package io.github.dadpea.texal.player.state;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class ServerBuildState extends PlayerState{

    @Override
    public void onEnter(Player p) {
        p.setGameMode(GameMode.CREATIVE);
    }
}
