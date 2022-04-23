package pl.oliver.tools.command.player;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import pl.oliver.tools.command.AbstractCommand;
import pl.oliver.tools.helper.ChatHelper;

public class ListCommand extends AbstractCommand {
    public ListCommand() {
        super("list", "tools.list");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        sender.sendMessage(ChatHelper.fixColor("&cLista osob online na serwerze: &7"+ Bukkit.getOnlinePlayers().size()));
        return true;
    }
}
