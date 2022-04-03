package io.github.dadpea.texal.commands.editing;

import io.github.dadpea.texal.commands.errors.*;
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
        if (!(sender instanceof Player)) throw new PlayerOnlyError();

        Player p = (Player) sender;

        if (args.length == 0) {
            throw new MissingParameterError("Index");
        }

        ItemStack item = p.getInventory().getItemInMainHand();
        if (item.getType().equals(Material.AIR)) {
            throw new MissingParameterError("Not holding");
        }


        int index;
        try {
            index = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            throw new InvalidParameterError("Index must be a number.");
        }

        ItemMeta m = item.getItemMeta();
        List<String> lore = m.getLore();
        if (lore == null) {
            throw new CustomError("No lore to remove.");
        }
        if (index > lore.size()) {
            throw new CustomError("Index out of range.");
        }

        lore.remove(index);
        m.setLore(lore);
        item.setItemMeta(m);
        p.getInventory().setItemInMainHand(item);
        return;
    }
    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
