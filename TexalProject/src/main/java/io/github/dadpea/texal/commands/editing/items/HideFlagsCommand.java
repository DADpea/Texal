package io.github.dadpea.texal.commands.editing.items;

import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.commands.editing.EditingCommand;
import io.github.dadpea.texal.commands.errors.CommandError;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HideFlagsCommand extends EditingCommand {
    @Override
    public void runCommand(CommandSender sender, String[] args) throws CommandError {
        TexalPlayer p = playerOnly(sender);
        ItemStack item = heldItem(p);
        ItemMeta m = item.getItemMeta();
        m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DYE,  ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(m);
        p.getPlayer().getInventory().setItemInMainHand(item);
    }
}
