package io.github.dadpea.texal.ranks;

import io.github.dadpea.texal.style.GlobalColors;

public enum Rank implements Comparable<Rank> {
    BENEFACTOR(10, GlobalColors.GRAY + "[" + GlobalColors.DARK_TEAL + "Benefactor" + GlobalColors.GRAY + "] ", GlobalColors.TEAL),
    MOD(20, GlobalColors.GRAY + "[" + GlobalColors.DARK_GREEN + "Mod" + GlobalColors.GRAY + "] ", GlobalColors.GREEN),
    ADMIN(30, GlobalColors.GRAY + "[" + GlobalColors.DARK_RED + "Admin" + GlobalColors.GRAY + "] ", GlobalColors.RED);

    private final int importance;
    private final String prefix;
    private final GlobalColors color;
    Rank(int i, String p, GlobalColors c) {
        this.importance = i;
        this.prefix = p;
        this.color = c;
    }

    public int getImportance() {
        return this.importance;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getColor() {
        return this.color.toString();
    }

}
