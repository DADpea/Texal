package io.github.dadpea.texal.chat;

import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.player.state.PlayerState;
import org.bukkit.entity.Player;

public class ScopeNone extends ChatScope {
    @Override
    public void sendMessage(TexalPlayer sender, String content) { super.sendTo(sender, sender, content); }

    @Override
    public boolean allowIncoming(TexalPlayer sender, TexalPlayer receiver) {
        return false;
    }
}
