package io.github.dadpea.texal;

import com.google.gson.Gson;
import io.github.dadpea.texal.chat.ChatScope;
import io.github.dadpea.texal.chat.ScopeLocal;
import io.github.dadpea.texal.player.state.LobbyState;
import io.github.dadpea.texal.player.state.PlayerState;
import io.github.dadpea.texal.plots.PlotPersistent;
import io.github.dadpea.texal.plots.exceptions.MalformedDataException;
import io.github.dadpea.texal.ranks.Ranks;
import org.bukkit.entity.Player;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class TexalPlayer {
    private static final Map<UUID, TexalPlayer> instances = new HashMap<>();
    private static final String directory = "playerData/";
    private final Player player;
    private Ranks ranks;
    private PlayerState state;
    private ChatScope chatScope;

    public void setChatScope(ChatScope chatScope) {
        this.chatScope = chatScope;
    }
    public ChatScope getChatScope() {
        return this.chatScope;
    }
    public Player getPlayer() {
        return this.player;
    }
    public Ranks getRanks() {
        return this.ranks;
    }
    public PlayerState getState() {
        return this.state;
    }
    public void setState(PlayerState s) {
        this.state = s;
    }

    /**
     * Get the TexalPlayer instance for this Player.
     * @param p Player
     * @return The TexalPlayer instance for this Player.
     */
    public static TexalPlayer create(Player p) {
        if (instances.containsKey(p.getUniqueId())) {
            return instances.get(p.getUniqueId());
        }
        TexalPlayer tp = new TexalPlayer(p);
        instances.put(p.getUniqueId(), tp);
        return tp;
    }

    private TexalPlayer(Player p) {
        this.player = p;
        this.state = new LobbyState();
        this.chatScope = new ScopeLocal();
        File f = new File(directory + p.getUniqueId() + ".json");
        if (f.exists()) {
            loadData();
        } else {
            this.ranks = new Ranks();
            saveData();
        }
    }

    protected void loadData() {
        File f = new File(directory + this.getPlayer().getUniqueId() + ".json");
        try (Reader r = new FileReader(f)) {
            Gson g = new Gson();
            PlayerPersistent persistent = g.fromJson(r, PlayerPersistent.class);
            this.ranks = persistent.getRanks();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void saveData() {
        File f = new File(directory + this.getPlayer().getUniqueId() + ".json");
        try (Writer r = new FileWriter(f)) {
            if (!f.exists()) f.createNewFile();
            Gson g = new Gson();
            g.toJson(new PlayerPersistent(this.ranks), PlayerPersistent.class, r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void decache() {
        instances.remove(this.getPlayer().getUniqueId());
    }
}
