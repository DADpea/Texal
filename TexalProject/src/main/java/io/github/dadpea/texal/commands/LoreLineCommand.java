package io.github.dadpea.texal.commands;

import io.github.dadpea.texal.ColorConvert;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class LoreLineCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player)) {
            return false;
        }


        Player p = (Player) sender;

        if(args.length<2) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "Usage: /sll <index> <string>");
            return true;
        }

        ItemStack item = p.getInventory().getItemInMainHand();
        if(item.getType().equals(Material.AIR)) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "Not holding an item.");
            return true;
        }

        int index;
        try {
            index = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "Index must be number");
            return true;
        }
        if(index<=0) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "Index must be < 0 ");
            return true;
        }

        ItemMeta m = item.getItemMeta();
        List<String> lore = m.getLore();
        if(lore == null) lore = new ArrayList<String>();

        int diff = index-lore.size();
        for(int i = 0; i<=diff; i++) lore.add(""); // loop

        StringBuilder text = new StringBuilder();
        for(int i = 1; i<args.length; i++) text.append(args[i]).append(" "); // loop

        lore.set(index-1, ColorConvert.translateColorCodes(text.toString()));
        m.setLore(lore);
        item.setItemMeta(m);

        p.getInventory().setItemInMainHand(item);
        return true;
    }
}
