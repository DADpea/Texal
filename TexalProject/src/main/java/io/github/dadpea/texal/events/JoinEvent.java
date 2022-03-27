package io.github.dadpea.texal.events;

import io.github.dadpea.texal.Texal;
import io.github.dadpea.texal.style.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage("");
        Player p = e.getPlayer();
        for (Player p1 : Bukkit.getOnlinePlayers()) {
            p1.sendMessage(Prefix.PREFIX_SERVER_INFO + "" + p.getDisplayName() + " joined!");
        }
        p.teleport(Texal.spawnPoint);
    }
}
