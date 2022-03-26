package io.github.dadpea.texal;

import org.bukkit.ChatColor;

public class ColorConvert {
    public static String fromHex(String s) {
        if (s.length()!=7) {
            throw new IllegalArgumentException("Hex must be seven chars, beginning with a #");
        }
        return ChatColor.COLOR_CHAR + "" + s.charAt(1)
             + ChatColor.COLOR_CHAR + "" + s.charAt(2)
             + ChatColor.COLOR_CHAR + "" + s.charAt(3)
             + ChatColor.COLOR_CHAR + "" + s.charAt(4)
             + ChatColor.COLOR_CHAR + "" + s.charAt(5)
             + ChatColor.COLOR_CHAR + "" + s.charAt(6);
    }
}
