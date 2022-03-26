package io.github.dadpea.texal.commands;

import org.bukkit.ChatColor;

public enum Prefix {
    PREFIX_SUCCESS(ChatColor.AQUA + "#✔ " + ChatColor.getByChar("#dbc491")),
    PREFIX_FAILURE(ChatColor.RED + "#✖ " + ChatColor.getByChar("#dbc491")),
    PREFIX_INFO(ChatColor.GOLD + "#! " + ChatColor.getByChar("#dbc491"));

    String s;
    private Prefix(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}
