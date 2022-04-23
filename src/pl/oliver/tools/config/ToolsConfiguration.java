package pl.oliver.tools.config;

import org.bukkit.entity.Player;
import pl.oliver.tools.helper.ChatHelper;

public class ToolsConfiguration {

    public void sendUsageCommand(final Player player, final String cmd) {
        player.sendMessage(ChatHelper.fixColor("&cPoprawne uzycie komendy &7"+cmd));
    }
}
