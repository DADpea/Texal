package io.github.dadpea.texal.commands.itemManipulation;

import io.github.dadpea.texal.style.Prefix;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class RemoveLoreLine implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player p = (Player) sender;

        if (args.length == 0) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "Usage: /rll <index>");
            return true;
        }

        ItemStack item = p.getInventory().getItemInMainHand();
        if (item.getType().equals(Material.AIR)) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "Not holding an item.");
            return true;
        }


        int index;
        try {
            index = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "Index must be a number.");
            return true;
        }

        ItemMeta m = item.getItemMeta();
        List<String> lore = m.getLore();
        if (lore == null) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "There is no lore.");
            return true;
        }
        if (index > lore.size()) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "Index out of range");
            return true;
        }

        lore.remove(index);
        m.setLore(lore);
        item.setItemMeta(m);
        p.getInventory().setItemInMainHand(item);
        return true;
    }
}
