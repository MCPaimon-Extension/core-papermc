package io.github.mcpaimon.extension.template.listeners;

import io.github.mcpaimon.bukkit.event.CreateModelEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * Listener for CreateModelEvent.
 * Provides an example of logging new AI models being registered.
 */
public class CreateModelListener implements Listener {

    @EventHandler
    public void onCreateModel(CreateModelEvent event) {
        String platformName = event.getPlatformName();
        String modelId = event.getModelId();

        // Example: Notify the console when a new model is registered under a platform
        System.out.println("[System] A new AI model '" + modelId + "' is being registered for platform: " + platformName);
    }
}
