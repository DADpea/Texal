package io.github.dadpea.texal.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemFactory {
    ItemStack outputItem;

    public ItemFactory(Material m) {
        this.outputItem = new ItemStack(m);
    }

    public ItemStack create() {
        return this.outputItem;
    }

    public ItemFactory setName(String s) {
        ItemMeta m = this.outputItem.getItemMeta();
        m.setDisplayName(s);
        this.outputItem.setItemMeta(m);
        return this;
    }

    public ItemFactory setLore(String... s) {
        ItemMeta m = this.outputItem.getItemMeta();
        m.setLore(Arrays.asList(s));
        this.outputItem.setItemMeta(m);
        return this;
    }

    public ItemFactory unbreakable() {
        ItemMeta m = this.outputItem.getItemMeta();
        m.setUnbreakable(true);
        this.outputItem.setItemMeta(m);
        return this;
    }

    public ItemFactory setTag(String i, String o) {
        ItemTags.setStringTag(outputItem,i,o);
        return this;
    }
}
