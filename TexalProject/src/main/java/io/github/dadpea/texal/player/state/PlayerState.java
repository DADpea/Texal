package io.github.dadpea.texal.player.state;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public interface PlayerState extends Listener {
    void onEnter(Player p);
    void onExit(Player p);
    void onTick(Player p);
}
