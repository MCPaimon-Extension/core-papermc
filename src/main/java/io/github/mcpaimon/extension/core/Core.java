package io.github.mcpaimon.extension.core;

import io.github.mcpaimon.mcextension.api.IMCExtension;
import io.github.mcpaimon.common.client.MCAIAPIClient;
import io.github.mcpaimon.extension.core.commands.MCAICommand;
import io.github.mcpaimon.extension.core.listeners.MCAIListener;
import io.github.mcpaimon.extension.core.tools.*;
import io.github.mcpaimon.papermc.MCAIPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * The core extension class for the MCAI system.
 * This class acts as the entry point for registering base commands, listeners, tools, 
 * and their respective categories dynamically into the runtime environment.
 */
public class Core implements IMCExtension {

    /**
     * Invoked when the extension is loaded by the extension manager.
     * @param plugin   The host JavaPlugin instance executing this extension.
     * @param executor The executor thread provided for async operations if needed.
     */
    @Override
    public void onLoad(JavaPlugin plugin, Executor executor) {
        if (plugin instanceof MCAIPlugin mcaiPlugin) {
            // Initialize API Client for the extension
            MCAIAPIClient aiClient = new MCAIAPIClient();

            // 1. Register Command Dynamically (Bypassing plugin.yml)
            MCAICommand aiCommandExecutor = new MCAICommand(mcaiPlugin, aiClient);
            Command dynamicAiCommand = new Command("ai") {
                @Override
                public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
                    return aiCommandExecutor.onCommand(sender, this, commandLabel, args);
                }

                @NotNull
                @Override
                public List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) {
                    List<String> completions = aiCommandExecutor.onTabComplete(sender, this, alias, args);
                    return completions != null ? completions : List.of();
                }
            };
            
            dynamicAiCommand.setDescription("Main command for MCAI");
            dynamicAiCommand.setAliases(List.of("mcai"));
            plugin.getServer().getCommandMap().register(plugin.getName().toLowerCase(), dynamicAiCommand);

            // 2. Register Listener
            plugin.getServer().getPluginManager().registerEvents(new MCAIListener(mcaiPlugin, mcaiPlugin.getProvider(), aiClient), plugin);

            // 3. Register Categories
            mcaiPlugin.getManager().createCategory("account_management", "Tools for managing user API tokens and accounts.");
            mcaiPlugin.getManager().createCategory("system_management", "Tools for managing the AI plugin system, platforms, and models.");
            mcaiPlugin.getManager().createCategory("admin", "Administrative tools that require operator (OP) permissions.");

            // 4. Register Tools
            mcaiPlugin.getManager().registerTool(new ChangeTokenTool());
            mcaiPlugin.getManager().registerTool(new SetTokenTool());
            mcaiPlugin.getManager().registerTool(new CreatePlatform());
            mcaiPlugin.getManager().registerTool(new CreateModel());
            mcaiPlugin.getManager().registerTool(new DeleteTokenTool());
            mcaiPlugin.getManager().registerTool(new GetTokenTool());

            plugin.getLogger().info("Core extension loaded successfully. Tools, Commands, Categories, and Listeners registered.");
        } else {
            plugin.getLogger().severe("Failed to load Core extension: Host plugin is not MCAIPlugin.");
        }
    }

    /**
     * Invoked when the extension is disabled.
     * @param plugin   The host JavaPlugin instance executing this extension.
     * @param executor The executor thread provided for async operations if needed.
     */
    @Override
    public void onDisable(JavaPlugin plugin, Executor executor) {
        plugin.getLogger().info("Core extension has been disabled.");
    }
}
