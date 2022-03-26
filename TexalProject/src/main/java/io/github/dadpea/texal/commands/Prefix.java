package io.github.dadpea.texal.commands;

import org.bukkit.Color;

public enum Prefix {
    PREFIX_SUCCESS(Color.AQUA + "[S] " + Color.SILVER),
    PREFIX_FAILURE(Color.RED + "[F] " + Color.SILVER),
    PREFIX_INFO(Color.ORANGE + "[I] " + Color.SILVER);

    String s;
    private Prefix(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}
