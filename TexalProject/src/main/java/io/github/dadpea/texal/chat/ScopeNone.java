package io.github.dadpea.texal.chat;

import org.bukkit.entity.Player;

public class ScopeNone extends ChatScope {
    @Override
    public void sendMessage(Player p, String content) {
        p.sendMessage();
    }

    @Override
    public boolean allowIncoming() {
        return false;
    }
}
