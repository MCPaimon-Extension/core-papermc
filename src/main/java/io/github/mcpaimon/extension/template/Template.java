package io.github.mcpaimon.extension.template;

import io.github.mcpaimon.extension.template.listeners.ChangeTokenListener;
import io.github.mcpaimon.extension.template.listeners.CreateModelListener;
import io.github.mcpaimon.extension.template.listeners.CreatePlatformListener;
import io.github.mcpaimon.extension.template.listeners.DeleteTokenListener;
import io.github.mcpaimon.extension.template.listeners.GetTokenListener;
import io.github.mcpaimon.extension.template.listeners.PreGenerateSummaryListener;
import io.github.mcpaimon.extension.template.listeners.SetTokenListener;
import io.github.mcpaimon.extension.template.tools.GetPlayerName;
import io.github.mcpaimon.extension.template.tools.GetPlayerUuid;
import io.github.mcpaimon.mcextension.api.IMCExtension;
import io.github.mcpaimon.papermc.MCAIPlugin;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.Executor;

public class Template implements IMCExtension {

    @Override
    public void onLoad(JavaPlugin plugin, Executor executor) {
        if (plugin instanceof MCAIPlugin mcaiPlugin) {
            
            // Create the custom category
            mcaiPlugin.getManager().createCategory("custom", "This is custom catagory");
            mcaiPlugin.getManager().createCategory("player", "Tools for player information and management");
            
            // Register your custom tools here
            mcaiPlugin.getManager().registerTool(new GetPlayerName());
            mcaiPlugin.getManager().registerTool(new GetPlayerUuid());
            
            // Register custom event listeners
            plugin.getServer().getPluginManager().registerEvents(new PreGenerateSummaryListener(), plugin);
            plugin.getServer().getPluginManager().registerEvents(new ChangeTokenListener(), plugin);
            plugin.getServer().getPluginManager().registerEvents(new SetTokenListener(), plugin);
            plugin.getServer().getPluginManager().registerEvents(new DeleteTokenListener(), plugin);
            plugin.getServer().getPluginManager().registerEvents(new GetTokenListener(), plugin);
            plugin.getServer().getPluginManager().registerEvents(new CreatePlatformListener(), plugin);
            plugin.getServer().getPluginManager().registerEvents(new CreateModelListener(), plugin);
            
            plugin.getLogger().info("Template extension loaded successfully. Tools and Listeners registered.");
        } else {
            plugin.getLogger().severe("Failed to load Template extension: Host plugin is not MCAIPlugin.");
        }
    }

    @Override
    public void onDisable(JavaPlugin plugin, Executor executor) {
        plugin.getLogger().info("Template extension has been disabled.");
    }
}
