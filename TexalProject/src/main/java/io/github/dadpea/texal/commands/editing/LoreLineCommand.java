package io.github.dadpea.texal.commands.editing;

import io.github.dadpea.texal.commands.errors.*;
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
        if(!(sender instanceof Player)) throw new PlayerOnlyError();


        Player p = (Player) sender;

        if(args.length<1) throw new MissingParameterError("Lore Line");
        if(args.length<2) throw new MissingParameterError("Text");


        ItemStack item = p.getInventory().getItemInMainHand();
        if(item.getType().equals(Material.AIR)) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "Not holding an item.");
            throw new CustomError("Not holding an item.");
        }

        int index;
        try {
            index = Integer.parseInt(args[0]);
            if (index<=0) {
                throw new InvalidParameterError("Index > 0.");
            }
        } catch (NumberFormatException e) {
            throw new InvalidParameterError("Index must be a number.");
        }

        ItemMeta m = item.getItemMeta();
        List<String> lore = m.getLore();
        if(lore == null) lore = new ArrayList<String>();

        int diff = index-lore.size();
        for (int i = 0; i<diff; i++) lore.add(""); // Loop to add lines up to index

        String text = "";
        for (int i = 0; i < args.length; i++) text += args[i] + (i==args.length-1 ? "" : " "); // so look i dont even know

        lore.set(index-1, ColorConvert.translateColorCodes(text)); // Setting lore
        m.setLore(lore);
        item.setItemMeta(m);

        p.getInventory().setItemInMainHand(item);
        return;
    }
    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
