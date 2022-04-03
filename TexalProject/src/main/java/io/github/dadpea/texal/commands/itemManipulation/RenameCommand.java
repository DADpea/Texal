package io.github.dadpea.texal.commands.itemManipulation;

import io.github.dadpea.texal.commands.TexalCommand;
import io.github.dadpea.texal.style.ColorConvert;
import io.github.dadpea.texal.style.Prefix;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class RenameCommand extends TexalCommand {
    @Override
    public boolean runCommand(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player p = (Player) sender;

        if (args.length == 0) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "Usage: /rename <string>");
            return true;
        }

        ItemStack item = p.getInventory().getItemInMainHand();
        if (item.getType().equals(Material.AIR)) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "Not holding an item.");
            return true;
        }

        ItemMeta m = item.getItemMeta();
        String text = "";
        for (int i = 0; i < args.length; i++) text += args[i] + (i==args.length-1 ? "" : " "); // so look i dont even know (REPLACE)

        m.setDisplayName(ColorConvert.translateColorCodes(text));
        item.setItemMeta(m);
        p.getInventory().setItemInMainHand(item);
        return true;
    }
    public boolean hasPermissions(CommandSender sender) {
        return true;
    }
    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}