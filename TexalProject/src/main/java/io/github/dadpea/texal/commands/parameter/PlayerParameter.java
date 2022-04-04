package io.github.dadpea.texal.commands.parameter;

import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.commands.errors.InvalidParameterError;
import io.github.dadpea.texal.commands.errors.MissingParameterError;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerParameter extends Parameter<TexalPlayer> {
    public PlayerParameter() {

    }
    public PlayerParameter(TexalPlayer def) {
        setValue(def);
    }

    @Override
    public void checkValid(String[] args, int pointer) throws InvalidParameterError {
        Player p = Bukkit.getPlayer(args[pointer]);
        if (p==null) throw new InvalidParameterError("Could not find player.");
        setValue(TexalPlayer.create(p));
    }

    @Override
    public List<String> getSuggestions() {
        List<String> out = new ArrayList<>();
        for (Player p : Bukkit.getOnlinePlayers()) {
            out.add(p.getName());
        }
        return out;
    }
}
