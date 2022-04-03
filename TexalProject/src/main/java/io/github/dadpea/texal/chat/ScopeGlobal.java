package io.github.dadpea.texal.chat;

import io.github.dadpea.texal.TexalPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ScopeGlobal extends ChatScope {
    @Override
    public void sendMessage(TexalPlayer sender, String content) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            TexalPlayer receiver = TexalPlayer.create(p);
            if (receiver.getChatScope().allowIncoming(sender, receiver)) {
                super.sendTo(sender, receiver, content);
            }
        }
    }

    @Override
    public boolean allowIncoming(TexalPlayer sender, TexalPlayer receiver) { return true; }
}
