package io.github.dadpea.texal.commands;

import io.github.dadpea.texal.ColorConvert;
import org.bukkit.ChatColor;

public enum Prefix {
    PREFIX_SUCCESS(ColorConvert.fromHex("#b7db91") + "#✔ " + ColorConvert.fromHex("#dbc491")),
    PREFIX_FAILURE(ColorConvert.fromHex("#db4848") + "#✖ " + ColorConvert.fromHex("#dbc491")),
    PREFIX_INFO(ChatColor.GOLD + "#! " + ColorConvert.fromHex("#dbc491"));

    String s;
    private Prefix(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}
