package io.github.dadpea.texal.chat;

import io.github.dadpea.texal.TexalPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ScopeLocal extends ChatScope {
    @Override
    public boolean allowIncoming(TexalPlayer sender, TexalPlayer receiver) {
        return sender.getState().equals(receiver.getState());
    }

    @Override
    public void sendMessage(TexalPlayer sender, String content) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            TexalPlayer receiver = TexalPlayer.create(p);
            if (receiver.getState().equals(sender.getState())) {
                if(receiver.getChatScope().allowIncoming(sender, receiver)) {
                    sendTo(sender, receiver, content);
                }
            }
        }
    }
}
