package io.github.dadpea.texal.commands.editing;

import io.github.dadpea.texal.commands.errors.CommandError;
import io.github.dadpea.texal.commands.errors.CustomError;
import io.github.dadpea.texal.commands.errors.MissingParameterError;
import io.github.dadpea.texal.commands.errors.PlayerOnlyError;
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
        if (!(sender instanceof Player))
            throw new PlayerOnlyError();

        Player p = (Player) sender;

        if (args.length == 0) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "Usage: /rename <string>");
            throw new MissingParameterError("Name");
        }

        ItemStack item = p.getInventory().getItemInMainHand();
        if (item.getType().equals(Material.AIR)) {
            throw new CustomError("Not holding an item.");
        }

        ItemMeta m = item.getItemMeta();
        String text = "";
        for (int i = 0; i < args.length; i++) text += args[i] + (i==args.length-1 ? "" : " "); // so look i dont even know (REPLACE)

        m.setDisplayName(ColorConvert.translateColorCodes(text));
        item.setItemMeta(m);
        p.getInventory().setItemInMainHand(item);
        return;
    }
    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}