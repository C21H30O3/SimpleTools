package pl.oliver.tools.command.player;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.oliver.tools.command.AbstractCommand;
import pl.oliver.tools.helper.ChatHelper;

public class FlyCommand extends AbstractCommand {
    public FlyCommand() {
        super("fly", "tools.fly");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        final Player player = (Player) sender;
        if(args.length < 2) {
            player.setAllowFlight(!player.getAllowFlight());
            ChatHelper.sendTitle(player, "&cFly zostal", (player.getAllowFlight() ? "&awlaczony" : "&cwylaczony"));
            return true;
        }
        final Player target = Bukkit.getPlayer(args[0]);
        if(target == null) {
            player.sendMessage(ChatHelper.fixColor("&cTego gracza nie ma na serwerze!"));
            return true;
        }
        player.setAllowFlight(!player.getAllowFlight());
        ChatHelper.sendTitle(target, "&cFly zostal", (player.getAllowFlight() ? "&awlaczony" : "&cwylaczony"));
        return true;
    }
}
