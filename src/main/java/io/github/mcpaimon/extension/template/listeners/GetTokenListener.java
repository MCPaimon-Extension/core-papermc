package io.github.mcpaimon.extension.template.listeners;

import io.github.mcpaimon.bukkit.event.GetTokenEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * Listener for GetTokenEvent.
 * Provides an example of auditing when tokens are viewed.
 */
public class GetTokenListener implements Listener {

    @EventHandler
    public void onGetToken(GetTokenEvent event) {
        String executorType = event.getExecutorAccount().accountType();
        String targetType = event.getTargetAccountType();
        String targetUuid = event.getTargetAccountUuid();

        // Example: Log whenever an account tries to view a token for auditing purposes
        System.out.println("[Audit Log] Executor [" + executorType + "] requested to view the token of [" + targetType + ":" + targetUuid + "].");
    }
}
