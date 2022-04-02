package io.github.dadpea.texal.ranks;

import io.github.dadpea.texal.style.GlobalColors;

public enum Rank implements Comparable<Rank> {
    BENEFACTOR(10, GlobalColors.GRAY + "[" + GlobalColors.DARK_YELLOW + "Benefactor" + GlobalColors.GRAY + "]", GlobalColors.YELLOW),
    MOD(20, GlobalColors.GRAY + "[" + GlobalColors.DARK_BLUE + "Mod" + GlobalColors.GRAY + "]", GlobalColors.BLUE),
    DEV(30, GlobalColors.GRAY + "[" + GlobalColors.DARK_GREEN + "Admin" + GlobalColors.GRAY + "]", GlobalColors.GREEN);

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
