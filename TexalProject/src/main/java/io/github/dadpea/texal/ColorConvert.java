package io.github.dadpea.texal;

import org.bukkit.ChatColor;
import static org.bukkit.ChatColor.COLOR_CHAR;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorConvert {
    public static String fromHex(String s) {
        if (s.length()!=7) {
            throw new IllegalArgumentException("Hex must be seven chars, beginning with a #");
        }
        return COLOR_CHAR + "x"
             + COLOR_CHAR + "" + s.charAt(1)
             + COLOR_CHAR + "" + s.charAt(2)
             + COLOR_CHAR + "" + s.charAt(3)
             + COLOR_CHAR + "" + s.charAt(4)
             + COLOR_CHAR + "" + s.charAt(5)
             + COLOR_CHAR + "" + s.charAt(6);
    }

    public static String translateColorCodes(String s) {
        return s.replaceAll("#([0-9A-Fa-f]){6}",
COLOR_CHAR + "x"
        + COLOR_CHAR + "$1"
        + COLOR_CHAR + "$2"
        + COLOR_CHAR + "$3"
        + COLOR_CHAR + "$4"
        + COLOR_CHAR + "$5"
        + COLOR_CHAR + "$6"
        ).replaceAll("&([A-Fa-f0-9])", COLOR_CHAR + "$1");
    }
}
