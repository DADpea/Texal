package io.github.dadpea.texal.style;

import org.bukkit.ChatColor;

import static io.github.dadpea.texal.style.GlobalColors.*;

public enum Prefix {
    PREFIX_SUCCESS(GREEN + "" + ChatColor.BOLD + "✔ " + DARK_GREEN),
    PREFIX_FAILURE(RED + "" + ChatColor.BOLD + "✖ " + DARK_RED),
    PREFIX_INFO(YELLOW + "" + ChatColor.BOLD + "! " + DARK_YELLOW),
    PREFIX_SERVER_INFO(LIGHT_GRAY + "" + ChatColor.BOLD + "> " + WHITE);

    String s;
    private Prefix(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}
