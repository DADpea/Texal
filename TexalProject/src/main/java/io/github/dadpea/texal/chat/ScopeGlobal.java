package io.github.dadpea.texal.chat;

import org.bukkit.entity.Player;

public class ScopeGlobal extends ChatScope {
    @Override
    public void sendMessage(Player p, String content) {

    }

    @Override
    public boolean allowIncoming() {
        return false;
    }
}
