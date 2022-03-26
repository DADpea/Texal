package io.github.dadpea.texal;

import io.github.dadpea.texal.commands.FlightspeedCommand;
import io.github.dadpea.texal.commands.PrefixTestCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Texal extends JavaPlugin {


    @Override
    public void onEnable() {
        this.getCommand("fs").setExecutor(new FlightspeedCommand());
        this.getCommand("flightspeed").setExecutor(new FlightspeedCommand());

        this.getCommand("prefixTest").setExecutor(new PrefixTestCommand());

    }
    @Override
    public void onDisable() {

    }
}
