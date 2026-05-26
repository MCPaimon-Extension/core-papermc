package io.github.mcpaimon.extension.template.listeners;

import io.github.mcpaimon.bukkit.event.DeleteTokenEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * Listener for DeleteTokenEvent.
 * Provides an example of preventing token deletion for critical accounts.
 */
public class DeleteTokenListener implements Listener {

    @EventHandler
    public void onDeleteToken(DeleteTokenEvent event) {
        String targetType = event.getTargetAccountType();

        // Example: Prevent deleting tokens assigned to the console
        if ("console".equalsIgnoreCase(targetType)) {
            event.setCancelled(true);
            System.out.println("[Security] Blocked an attempt to delete the console's token.");
        }
    }
}
