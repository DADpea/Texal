package io.github.dadpea.texal;

import io.github.dadpea.texal.ranks.Rank;
import io.github.dadpea.texal.ranks.Ranks;

import java.io.Serializable;

public class PlayerPersistent implements Serializable {
    private Ranks ranks;

    public PlayerPersistent() {
        this.ranks = new Ranks();
    }

    public PlayerPersistent(Ranks r) {
        this.ranks = r;
    }

    public Ranks getRanks() {
        return ranks;
    }

    public void setRanks(Ranks ranks) {
        this.ranks = ranks;
    }
}
