package pl.oliver.tools.command.player;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.oliver.tools.ToolsPlugin;
import pl.oliver.tools.command.AbstractCommand;
import pl.oliver.tools.helper.ChatHelper;
import pl.oliver.tools.helper.PluginHelper;

import java.util.Locale;

public class GameModeCommand extends AbstractCommand {
    public GameModeCommand() {
        super("gamemode", new String[]{"gm"}, "tools.gm");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        final Player player = (Player) sender;
        if(args.length < 1 || args.length > 3) {
            getPlugin().getToolsConfiguration().sendUsageCommand(player, "/gamemode [0/1/2/3] [gracz]");
            return true;
        }
        final String mode = args[0];
        final GameMode gameMode;
        if(args.length < 2) {
            if(PluginHelper.isInteger(args[0])) {
                gameMode = GameMode.getByValue(Integer.parseInt(mode));
                player.setGameMode(gameMode);
                ChatHelper.sendTitle(player, "&cTryb gry zmieniony na", "&7"+gameMode.name());
                return true;
            }
            gameMode = GameMode.valueOf(mode.toUpperCase(Locale.ROOT));
            player.setGameMode(gameMode);
            ChatHelper.sendTitle(player, "&cTryb gry zmieniony na", "&7"+gameMode.name());
            return true;
        }
        final Player target = Bukkit.getPlayer(args[1]);
        if(target == null) {
            player.sendMessage(ChatHelper.fixColor("&cTego gracza nie ma na serwerze!"));
            return true;
        }
        if (PluginHelper.isInteger(args[0])) {
            gameMode = GameMode.getByValue(Integer.parseInt(mode));
            target.setGameMode(gameMode);
            ChatHelper.sendTitle(player, "&cTryb gry zmieniony na", "&7"+gameMode.name());
            return true;
        }
        gameMode = GameMode.valueOf(mode.toUpperCase(Locale.ROOT));
        target.setGameMode(gameMode);
        ChatHelper.sendTitle(player, "&cTryb gry zmieniony na", "&7"+gameMode.name());
        return true;
    }
}
