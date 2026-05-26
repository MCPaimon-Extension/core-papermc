package io.github.mcpaimon.extension.template.listeners;

import io.github.mcpaimon.bukkit.event.SetTokenEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * Listener for SetTokenEvent.
 * Provides an example of validating a newly set token.
 */
public class SetTokenListener implements Listener {

    @EventHandler
    public void onSetToken(SetTokenEvent event) {
        String token = event.getToken();

        // Example: Simple validation to check if the token is too short
        if (token != null && token.length() < 10) {
            event.setCancelled(true);
            System.out.println("[Security] Blocked an attempt to set an unusually short token.");
        }
    }
}
