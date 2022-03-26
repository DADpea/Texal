package io.github.dadpea.texal;

import io.github.dadpea.texal.commands.FlightspeedCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Texal extends JavaPlugin {


    @Override
    public void onEnable() {
        this.getCommand("fs").setExecutor(new FlightspeedCommand());

    }
    @Override
    public void onDisable() {

    }
}
