package pl.oliver.tools.helper;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatHelper {

    public static void sendTitle(final Player player, final String title, final String sub) {
        player.sendTitle(fixColor(title), fixColor(sub));
    }

    public static String fixColor(final String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
