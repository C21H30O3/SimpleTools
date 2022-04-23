package pl.oliver.tools;

import lombok.Getter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import pl.oliver.tools.command.player.FlyCommand;
import pl.oliver.tools.command.player.GameModeCommand;
import pl.oliver.tools.config.ToolsConfiguration;
import pl.oliver.tools.listener.PlayerJoinQuitListener;

public class ToolsPlugin extends JavaPlugin {

    @Getter
    private ToolsConfiguration toolsConfiguration;
    @Getter
    private static ToolsPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        this.toolsConfiguration = new ToolsConfiguration();
        new GameModeCommand();
        new FlyCommand();
        registerListeners(new PlayerJoinQuitListener());
    }

    public void registerListeners(Listener... listeners) {
        for (Listener listener : listeners) {
            getServer().getPluginManager().registerEvents(listener, this);
        }
    }
    @Override
    public void onDisable() {
    }
}
