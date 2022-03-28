package io.github.dadpea.texal.item;

import io.github.dadpea.texal.Texal;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class ItemTags {
    public static String getStringTag(ItemStack item, String tagName) {
        ItemMeta m = item.getItemMeta();
        PersistentDataContainer c = m.getPersistentDataContainer();
        return c.get(NamespacedKey.fromString(tagName, Texal.plugin), PersistentDataType.STRING);
    }

    public static void setStringTag(ItemStack item, String tagName, String tagValue) {
        ItemMeta m = item.getItemMeta();
        PersistentDataContainer c = m.getPersistentDataContainer();
        c.set(NamespacedKey.fromString(tagName, Texal.plugin), PersistentDataType.STRING, tagValue);
        item.setItemMeta(m);
        return;
    }
}
