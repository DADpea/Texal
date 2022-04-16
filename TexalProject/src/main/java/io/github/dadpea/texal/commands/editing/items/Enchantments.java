package io.github.dadpea.texal.commands.editing.items;

import org.bukkit.enchantments.Enchantment;

public enum Enchantments {
    MENDING(Enchantment.MENDING),
    UNBREAKING(Enchantment.DURABILITY),
    VANISHING(Enchantment.VANISHING_CURSE),
    BINDING(Enchantment.BINDING_CURSE),
    AQUA_AFFINITY(Enchantment.WATER_WORKER),
    BLAST_PROTECTION(Enchantment.PROTECTION_EXPLOSIONS),
    DEPTH_STRIDER(Enchantment.DEPTH_STRIDER),
    FEATHER_FALLING(Enchantment.PROTECTION_FALL),
    FIRE_PROTECTION(Enchantment.PROTECTION_FIRE),
    FROST_WALKER(Enchantment.FROST_WALKER),
    PROJECTILE_PROTECTION(Enchantment.PROTECTION_PROJECTILE),
    PROTECTION(Enchantment.PROTECTION_ENVIRONMENTAL),
    RESPIRATION(Enchantment.OXYGEN),
    SOUL_SPEED(Enchantment.SOUL_SPEED),
    THORNS(Enchantment.THORNS),
    BANE_OF_ARTHROPODS(Enchantment.DAMAGE_ARTHROPODS),
    EFFICIENCY(Enchantment.DIG_SPEED),
    FIRE_ASPECT(Enchantment.FIRE_ASPECT),
    LOOTING(Enchantment.LOOT_BONUS_MOBS),
    IMPALING(Enchantment.IMPALING),
    KNOCKBACK(Enchantment.KNOCKBACK),
    SHARPNESS(Enchantment.DAMAGE_ALL),
    SWEEPING_EDGE(Enchantment.SWEEPING_EDGE),
    CHANNELING(Enchantment.CHANNELING),
    FLAME(Enchantment.ARROW_FIRE),
    INFINITY(Enchantment.ARROW_INFINITE),
    LOYALTY(Enchantment.LOYALTY),
    RIPTIDE(Enchantment.RIPTIDE),
    MULTISHOT(Enchantment.MULTISHOT),
    PIERCING(Enchantment.PIERCING),
    POWER(Enchantment.ARROW_DAMAGE),
    PUNCH(Enchantment.ARROW_KNOCKBACK),
    QUICK_CHARGE(Enchantment.QUICK_CHARGE),
    FORTUNE(Enchantment.LOOT_BONUS_BLOCKS),
    LUCK_OF_THE_SEA(Enchantment.LUCK),
    LURE(Enchantment.LURE),
    SILK_TOUCH(Enchantment.SILK_TOUCH);


    Enchantment enchantment;
    private Enchantments(Enchantment enchantment) { this.enchantment = enchantment; }

    public Enchantment getEnchantment() { return enchantment; }
}
