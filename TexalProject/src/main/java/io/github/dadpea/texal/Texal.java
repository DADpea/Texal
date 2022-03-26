package io.github.dadpea.texal;

import io.github.dadpea.texal.commands.FlightspeedCommand;
import io.github.dadpea.texal.commands.PrefixTestCommand;
import io.github.dadpea.texal.commands.UnloadWorldCommand;
import io.github.dadpea.texal.commands.WorldTestCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Texal extends JavaPlugin {


    @Override
    public void onEnable() {
        this.getCommand("fs").setExecutor(new FlightspeedCommand());
        this.getCommand("flightspeed").setExecutor(new FlightspeedCommand());

        this.getCommand("prefixTest").setExecutor(new PrefixTestCommand());

        this.getCommand("worldTest").setExecutor(new WorldTestCommand()); // temp
        this.getCommand("unloadWorld").setExecutor(new UnloadWorldCommand()); // temp
    }
    @Override
    public void onDisable() {

    }
}
