package pl.oliver.tools.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import pl.oliver.tools.helper.ChatHelper;

public class PlayerJoinQuitListener implements Listener {

    @SuppressWarnings("unused")
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        final Player player = e.getPlayer();
        if(!player.hasPlayedBefore()) {
            player.getInventory().addItem(new ItemStack(Material.STONE_PICKAXE), new ItemStack(Material.COOKED_BEEF));
        }
        ChatHelper.sendTitle(player, "&7[ &c&lTOOLS &7]", "&7Witamy na serwerze!");
        for (int i = 0; i < 65; i++) {
            player.sendMessage("");
        }
        player.sendMessage(ChatHelper.fixColor("&cWiecej informacji o serwerze znajdziesz pod komenda &7/pomoc"));
        player.sendMessage(ChatHelper.fixColor("&cIlosc osob online: &7"+ Bukkit.getOnlinePlayers().size()));
        e.setJoinMessage(null);
    }
    @SuppressWarnings("unused")
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(null);
    }
}
