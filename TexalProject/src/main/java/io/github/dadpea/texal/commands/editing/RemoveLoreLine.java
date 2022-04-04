package io.github.dadpea.texal.commands.editing;

import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.commands.errors.*;
import io.github.dadpea.texal.commands.parameter.IntParameter;
import io.github.dadpea.texal.commands.parameter.ParameterList;
import io.github.dadpea.texal.commands.parameter.StringParameter;
import io.github.dadpea.texal.style.Prefix;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class RemoveLoreLine extends EditingCommand {
    @Override
    public void runCommand(CommandSender sender, String[] args) throws CommandError {
        TexalPlayer p = playerOnly(sender);

        ParameterList pl = new ParameterList();
        IntParameter lineNum = pl.add(new IntParameter());
        pl.testAgainst(args);

        ItemStack item = heldItem(p);

        ItemMeta m = item.getItemMeta();
        List<String> lore = m.getLore();
        if (lore == null) {
            throw new CustomError("No lore to remove.");
        }
        if (lineNum.getValue() > lore.size()) {
            throw new CustomError("Index out of range.");
        }

        lore.remove(lineNum.getValue());
        m.setLore(lore);
        item.setItemMeta(m);
        p.getPlayer().getInventory().setItemInMainHand(item);
    }
    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        ParameterList pl = new ParameterList();
        pl.add(new IntParameter());
        return pl.tabComplete(args);
    }
}
