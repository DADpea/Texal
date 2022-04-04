package io.github.dadpea.texal.commands.global;

import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.chat.ChatScopes;
import io.github.dadpea.texal.chat.ScopeGlobal;
import io.github.dadpea.texal.chat.ScopeLocal;
import io.github.dadpea.texal.chat.ScopeNone;
import io.github.dadpea.texal.commands.errors.CommandError;
import io.github.dadpea.texal.commands.errors.InvalidParameterError;
import io.github.dadpea.texal.commands.errors.MissingParameterError;
import io.github.dadpea.texal.commands.errors.NoPermissionError;
import io.github.dadpea.texal.commands.parameter.EnumParameter;
import io.github.dadpea.texal.commands.parameter.ParameterList;
import io.github.dadpea.texal.style.Prefix;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class ChatScopeCommand extends GlobalCommand {
    @Override
    public void runCommand(CommandSender sender, String[] args) throws CommandError {
        TexalPlayer p = playerOnly(sender);

        ParameterList pl = new ParameterList();
        EnumParameter<ChatScopes> scope = pl.add(new EnumParameter<>(ChatScopes.class));
        pl.testAgainst(args);

        p.setChatScope(scope.getValue().getScope());
        p.sendMessage(Prefix.PREFIX_SUCCESS + "Set chat to " + scope.getValue() + ".");
    }
    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        ParameterList pl = new ParameterList();
        pl.add(new EnumParameter<>(ChatScopes.class));
        return pl.tabComplete(args);
    }
}
