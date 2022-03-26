package io.github.dadpea.texal;

public enum Rank {
    DEFAULT(0), BENEFACTOR(0), MOD(1), DEV(2);

    int opLevel;
    private Rank(int i) {
        this.opLevel = i;
    }
}
