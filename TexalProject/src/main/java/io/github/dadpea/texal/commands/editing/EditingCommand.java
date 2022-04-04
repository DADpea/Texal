package io.github.dadpea.texal.commands.editing;

import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.commands.TexalCommand;
import io.github.dadpea.texal.commands.errors.CommandError;
import io.github.dadpea.texal.commands.errors.CustomError;
import io.github.dadpea.texal.commands.errors.MissingParameterError;
import io.github.dadpea.texal.commands.errors.NoPermissionError;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public abstract class EditingCommand extends TexalCommand {
    @Override
    public final void permissionCheck(CommandSender sender) throws NoPermissionError {
        if (!(sender instanceof Player))
            throw new NoPermissionError();
    }

    @Override
    public abstract void runCommand(CommandSender sender, String[] args) throws CommandError;

    protected static ItemStack heldItem(TexalPlayer p) throws CustomError {
        ItemStack item = p.getPlayer().getInventory().getItemInMainHand();
        if (item.getType().equals(Material.AIR)) {
            throw new CustomError("Not holding an item.");
        }
        return item;
    }
}
