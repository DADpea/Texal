package io.github.dadpea.texal.chat;


import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.player.state.PlayerState;
import io.github.dadpea.texal.style.GlobalColors;
import org.bukkit.entity.Player;

import java.util.regex.Pattern;

public abstract class ChatScope {
    public abstract void sendMessage(TexalPlayer sender, String content);
    public abstract boolean allowIncoming( TexalPlayer sender, TexalPlayer receiver );

    protected void sendTo(TexalPlayer sender, TexalPlayer receiver, String content) {
        Pattern p = Pattern.compile("(" + receiver.getPlayer().getName() + ")",
                Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
        content = p.matcher(content).replaceAll(GlobalColors.TEAL + "$1" + GlobalColors.WHITE);
        receiver.getPlayer().sendMessage(sender.getRanks().getChatPrefix() + sender.getPlayer().getDisplayName() + GlobalColors.WHITE + ": " + content);
    }
}
