package io.github.mcpaimon.extension.template.listeners;

import io.github.mcpaimon.bukkit.event.CreatePlatformEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * Listener for CreatePlatformEvent.
 * Provides an example of logging new AI platforms dynamically added to the system.
 */
public class CreatePlatformListener implements Listener {

    @EventHandler
    public void onCreatePlatform(CreatePlatformEvent event) {
        String platformName = event.getPlatformName();
        String url = event.getUrl();

        // Example: Notify the console when a new platform is registered
        System.out.println("[System] A new AI platform is being registered: " + platformName + " (" + url + ")");
    }
}
