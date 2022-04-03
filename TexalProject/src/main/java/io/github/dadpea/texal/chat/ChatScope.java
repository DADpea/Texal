package io.github.dadpea.texal.chat;


import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.player.state.PlayerState;
import io.github.dadpea.texal.style.GlobalColors;
import org.bukkit.entity.Player;

public abstract class ChatScope {
    public abstract void sendMessage(TexalPlayer sender, String content);
    public abstract boolean allowIncoming( TexalPlayer sender, TexalPlayer receiver );

    protected void sendTo(TexalPlayer sender, TexalPlayer receiver, String content) {
        receiver.getPlayer().sendMessage(sender.getRanks().getChatPrefix() + sender.getPlayer().getDisplayName() + GlobalColors.WHITE + ": " + content);
    }
}
