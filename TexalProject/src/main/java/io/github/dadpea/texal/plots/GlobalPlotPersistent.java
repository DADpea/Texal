package io.github.dadpea.texal.plots;

import java.io.Serializable;

public class GlobalPlotPersistent implements Serializable {
    private int nextID;

    public GlobalPlotPersistent() {
        this.nextID = 0;
    }

    public int getNextID() {
        return nextID;
    }
    public void setNextID(int nextID) {
        this.nextID = nextID;
    }
}
