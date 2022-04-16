package io.github.dadpea.texal.commands.editing.items;

import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.chat.ChatScopes;
import io.github.dadpea.texal.commands.editing.EditingCommand;
import io.github.dadpea.texal.commands.errors.CommandError;
import io.github.dadpea.texal.commands.errors.CustomError;
import io.github.dadpea.texal.commands.errors.MissingParameterError;
import io.github.dadpea.texal.commands.errors.PlayerOnlyError;
import io.github.dadpea.texal.commands.parameter.EnumParameter;
import io.github.dadpea.texal.commands.parameter.ParameterList;
import io.github.dadpea.texal.commands.parameter.StringParameter;
import io.github.dadpea.texal.style.ColorConvert;
import io.github.dadpea.texal.style.Prefix;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class RenameCommand extends EditingCommand {
    @Override
    public void runCommand(CommandSender sender, String[] args) throws CommandError {
        TexalPlayer p = playerOnly(sender);

        ParameterList pl = new ParameterList();
        StringParameter name = pl.add(new StringParameter());
        pl.testAgainst(args);

        ItemStack item = heldItem(p);

        ItemMeta m = item.getItemMeta();
        m.setDisplayName(ColorConvert.translateColorCodes(name.getValue()));
        item.setItemMeta(m);
        p.getPlayer().getInventory().setItemInMainHand(item);
    }
    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        ParameterList pl = new ParameterList();
        pl.add(new StringParameter());
        return pl.tabComplete(args);
    }
}