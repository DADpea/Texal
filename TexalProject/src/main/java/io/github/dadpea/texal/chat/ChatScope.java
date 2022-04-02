package io.github.dadpea.texal.chat;


import org.bukkit.entity.Player;

public abstract class ChatScope {
    public abstract void sendMessage(Player p, String content);
    public abstract boolean allowIncoming();
}
