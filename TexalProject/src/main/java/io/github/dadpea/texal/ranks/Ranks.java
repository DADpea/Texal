package io.github.dadpea.texal.ranks;

import io.github.dadpea.texal.style.GlobalColors;

import java.util.ArrayList;
import java.util.HashSet;

public class Ranks {
    private final HashSet<Rank> ranks;

    public Ranks() {
        this.ranks = new HashSet<>();
    }

    public void addRank(Rank r) {
        this.ranks.add(r);
    }
    public void removeRank(Rank r) {
        this.ranks.remove(r);
    }

    public ArrayList<Rank> getHighestRanks() {
        ArrayList<Rank> out = new ArrayList<>();
        int highestVal = 0;
        for (Rank r : ranks) {
            if (r.getImportance() > highestVal) {
                out.clear();
                highestVal = r.getImportance();
                out.add(r);
            } else if (r.getImportance() == highestVal) {
                out.add(r);
            }
        }
        return out;
    }

    public String getChatPrefix() {
        StringBuilder prefix = new StringBuilder();
        ArrayList<Rank> rs = getHighestRanks();
        for (Rank r : rs) {
            prefix.append(r.getPrefix());
        }
        prefix.append(rs.size() > 0 ? rs.get(0).getColor() : GlobalColors.LIGHT_GRAY);
        return prefix.toString();
    }

    // Permission level
    public int getImportance() {
        ArrayList<Rank> rs = getHighestRanks();
        if (rs.size()>0) return rs.get(0).getImportance();
        return 0;
    }
}
