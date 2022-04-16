package io.github.dadpea.texal.commands.editing.items;

import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.commands.editing.EditingCommand;
import io.github.dadpea.texal.commands.errors.*;
import io.github.dadpea.texal.commands.parameter.IntParameter;
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

import java.util.ArrayList;
import java.util.List;

public class LoreLineCommand extends EditingCommand {
    @Override
    public void runCommand(CommandSender sender, String[] args) throws CommandError {
        TexalPlayer p = playerOnly(sender);

        ParameterList pl = new ParameterList();
        IntParameter lineNum = pl.add(new IntParameter());
        StringParameter textParam = pl.add(new StringParameter());
        pl.testAgainst(args);

        ItemStack item = heldItem(p);

        ItemMeta m = item.getItemMeta();
        List<String> lore = m.getLore();
        if(lore == null) lore = new ArrayList<String>();

        int diff = lineNum.getValue()-lore.size();
        for (int i = 0; i<diff; i++) lore.add(""); // Loop to add lines up to index

        lore.set(lineNum.getValue()-1, ColorConvert.translateColorCodes(textParam.getValue())); // Setting lore
        m.setLore(lore);
        item.setItemMeta(m);

        p.getPlayer().getInventory().setItemInMainHand(item);
    }
    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        ParameterList pl = new ParameterList();
        pl.add(new IntParameter());
        pl.add(new StringParameter());
        return pl.tabComplete(args);
    }
}
