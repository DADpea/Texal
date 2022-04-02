package io.github.dadpea.texal.player.state;

import io.github.dadpea.texal.Texal;
import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.item.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;

import static io.github.dadpea.texal.style.GlobalColors.LIGHT_GRAY;
import static io.github.dadpea.texal.style.GlobalColors.WHITE;

public class LobbyState implements PlayerState {

    public LobbyState() {

    }

    @Override
    public void onEnter(Player p) {
        p.teleport(Texal.spawnPoint);
        p.setFlySpeed(0.1f);
        p.setWalkSpeed(0.2f);
        p.setExp(0f);
        p.setLevel(0);
        p.setHealth(20);
        p.setFlying(false);
        p.setGameMode(GameMode.SURVIVAL);
        p.setScoreboard(Texal.spawnBoard);
        p.getInventory().clear();

        p.getInventory().setItem(2,
                new ItemFactory(Material.IRON_INGOT)
                        .setName(WHITE + "Public Plots")
                        .setLore(LIGHT_GRAY + "Right click to view public plots you can play!")
                        .setTag("texal_default", "spawn_public_plots")
                        .create()
        );
        p.getInventory().setItem(4,
                new ItemFactory(Material.GOLD_INGOT)
                        .setName(WHITE + "My Plots")
                        .setLore(LIGHT_GRAY + "Right click to view your plots or access tutorials!")
                        .setTag("texal_default", "spawn_my_plots")
                        .create()
        );
        p.getInventory().setItem(6,
                new ItemFactory(Material.NETHERITE_INGOT)
                        .setName(WHITE + "Settings")
                        .setLore(LIGHT_GRAY + "Right click to view or edit your settings!")
                        .setTag("texal_default", "spawn_settings")
                        .create()
        );
        p.getInventory().setHeldItemSlot(5);

    }

    @Override
    public void onExit(Player p) {

    }

    @Override
    public void onTick(Player p) {
        p.setFoodLevel(20);
        p.setSaturation(20f);
    }

    @Override
    public void onDamage(EntityDamageEvent e) {
        e.setCancelled(true);
    }

    @Override
    public void onRespawn(PlayerRespawnEvent e) {
        e.getPlayer().teleport(Texal.spawnPoint);
    }

    @Override
    public void onBlockBreak(BlockBreakEvent e) {
        e.setCancelled(true);
    }

    @Override
    public void onChat(AsyncPlayerChatEvent e) {
        e.setCancelled(true);
        for (Player p: Bukkit.getOnlinePlayers()) {
            PlayerState ps = TexalPlayer.create(p).getState();
            if(ps instanceof LobbyState || ps instanceof ServerBuildState) {
                p.sendMessage(e.getPlayer().getDisplayName() + ": " + e.getMessage());
            }
        }
    }

    @Override
    public void onDropItem(PlayerDropItemEvent e) {
        e.setCancelled(true);
    }

    @Override
    public void onSwapSlots(PlayerChangedMainHandEvent e) {

    }

    @Override
    public void onSneak(PlayerToggleSneakEvent e) {

    }

    @Override
    public void onSprint(PlayerToggleSprintEvent e) {

    }

    @Override
    public void onDeath(PlayerDeathEvent e) {

    }

    @Override
    public void onInteract(PlayerInteractEvent e) {
        e.setCancelled(true);
    }

    @Override
    public void onSwapHands(PlayerSwapHandItemsEvent e) {
        e.setCancelled(true);
    }


}
