package pl.oliver.tools.command;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import pl.oliver.tools.ToolsPlugin;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AbstractCommand implements CommandExecutor {

    private static CommandMap commandMap;
    @Getter
    private final ToolsPlugin plugin = ToolsPlugin.getInstance();

    private final String command;
    private final String description;
    private final List<String> alias;
    private final String usage;
    private final String permMessage;
    private final String perm;

    public AbstractCommand(String command, String perm) {
        this(command, new ArrayList<>(), perm);
    }

    public AbstractCommand(String command, String[] aliases, String perm) {
        this(command, Arrays.asList(aliases), perm);
    }

    private AbstractCommand(String command, List<String> aliases, String perm) {
        this.description = null;
        this.usage = null;
        this.permMessage = null;
        this.command = command.toLowerCase();
        this.alias = aliases;
        this.perm = perm;
        this.register();
    }



    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        return false;
    }



    private void register() {
        ReflectCommand cmd = new ReflectCommand(this, this.command);
        if (this.alias != null) {
            cmd.setAliases(this.alias);
        }
        if (this.description != null) {
            cmd.setDescription(this.description);
        }
        if (this.usage != null) {
            cmd.setUsage(this.usage);
        }
        if (this.permMessage != null) {
            cmd.setPermissionMessage(this.permMessage);
        }
        this.getCommandMap().register("", cmd);
        cmd.setExecutor(this);
    }

    private CommandMap getCommandMap() {
        if (commandMap != null) {
            return commandMap;
        }
        try {
            commandMap = (CommandMap) getValue(Bukkit.getServer(), "commandMap");
            return commandMap;
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.getCommandMap();
        }
    }
    public static Object getValue(Object instance, String fieldName) {
        try {
            Field field = instance.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(instance);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String getPerm() {
        return perm;
    }



}
