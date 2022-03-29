package io.github.dadpea.texal;

import io.github.dadpea.texal.plots.GlobalPlotPersistent;

import java.io.Serializable;

public class ServerPersistent implements Serializable {

    private GlobalPlotPersistent plotPersistent;

    public ServerPersistent() {
        this.plotPersistent = new GlobalPlotPersistent();
    }


    public GlobalPlotPersistent getPlotPersistent() {
        return plotPersistent;
    }

    public void setPlotPersistent(GlobalPlotPersistent plotPersistent) {
        this.plotPersistent = plotPersistent;
    }
}
