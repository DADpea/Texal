package io.github.dadpea.texal.commands;

import io.github.dadpea.texal.ColorConvert;
import org.bukkit.ChatColor;

public enum Prefix {
    PREFIX_SUCCESS(ColorConvert.fromHex("#bbdd99") + "" + ChatColor.BOLD + "✔ " + ColorConvert.fromHex("#88dd77")),
    PREFIX_FAILURE(ColorConvert.fromHex("#dd5050") + "" + ChatColor.BOLD + "✖ " + ColorConvert.fromHex("#dd2020")),
    PREFIX_INFO(ColorConvert.fromHex("#ccffff") + "" + ChatColor.BOLD + "! " + ColorConvert.fromHex("#88FFFF")),  // fix this later O_O
    PREFIX_SERVER_INFO(ColorConvert.fromHex("#cccccc") + "" + ChatColor.BOLD + "> " + ColorConvert.fromHex("#999999"));

    String s;
    private Prefix(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}
