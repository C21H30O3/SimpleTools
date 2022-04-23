package pl.oliver.tools.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import java.io.IOError;

final class ReflectCommand extends Command {
    private AbstractCommand execute;
    final AbstractCommand abstractCommand;

    ReflectCommand(AbstractCommand abstractCommand, String command) {
        super(command);
        this.abstractCommand = abstractCommand;
        this.execute = null;
    }

    public void setExecutor(AbstractCommand execute) {
        this.execute = execute;
    }

    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        final Player player = (Player) sender;
        if (!sender.isOp() || !sender.hasPermission(execute.getPerm())) {
            player.sendTitle("&cNie masz dostepu do tej komendy!", "");
            return true;
        }

        try {
            if (this.execute != null) {
                this.execute.onCommand(sender, this, commandLabel, args);
            }
        } catch (IOError ioError) {
            ioError.printStackTrace();
        }
        return true;
    }

}
