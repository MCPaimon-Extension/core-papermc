package io.github.mcpaimon.extension.template.listeners;

import io.github.mcpaimon.bukkit.event.ChangeTokenEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * Listener for ChangeTokenEvent.
 * Provides an example of intercepting and validating token changes.
 */
public class ChangeTokenListener implements Listener {

    @EventHandler
    public void onChangeToken(ChangeTokenEvent event) {
        String targetType = event.getTargetAccountType();

        // Example: Prevent users or tools from modifying the console's API token
        if ("console".equalsIgnoreCase(targetType)) {
            event.setCancelled(true);
            System.out.println("[Security] Blocked an attempt to change the console's token.");
        }
    }
}
