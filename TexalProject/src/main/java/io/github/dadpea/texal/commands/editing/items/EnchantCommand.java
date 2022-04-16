package io.github.dadpea.texal.commands.editing.items;

import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.commands.editing.EditingCommand;
import io.github.dadpea.texal.commands.errors.CommandError;
import io.github.dadpea.texal.commands.parameter.EnumParameter;
import io.github.dadpea.texal.commands.parameter.IntParameter;
import io.github.dadpea.texal.commands.parameter.ParameterList;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class EnchantCommand extends EditingCommand {
    @Override
    public void runCommand(CommandSender sender, String[] args) throws CommandError {
        TexalPlayer p = playerOnly(sender);

        ParameterList pl = new ParameterList();
        EnumParameter<Enchantments> enchantmentsParam = pl.add(new EnumParameter<>(Enchantments.class));
        IntParameter intParameter = pl.add(new IntParameter());
        pl.testAgainst(args);

        ItemStack item = heldItem(p);


        ItemMeta m = item.getItemMeta();
        if (intParameter.getValue()==0) { m.removeEnchant(enchantmentsParam.getValue().getEnchantment()); }
        else { m.addEnchant(enchantmentsParam.getValue().getEnchantment(), intParameter.getValue(), true); }
        item.setItemMeta(m);
        p.getPlayer().getInventory().setItemInMainHand(item);
    }
    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        ParameterList pl = new ParameterList();
        pl.add(new EnumParameter<>(Enchantments.class));
        pl.add(new IntParameter());
        return pl.tabComplete(args);
    }
}
