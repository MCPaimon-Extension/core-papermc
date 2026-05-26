package io.github.mcpaimon.extension.template.listeners;

import io.github.mcpaimon.bukkit.event.PreGenerateSummaryEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * Listener for PreGenerateSummaryEvent.
 * Appends custom context to the AI before the final summary is generated.
 */
public class PreGenerateSummaryListener implements Listener {

    @EventHandler
    public void onPreGenerateSummary(PreGenerateSummaryEvent event) {
        String currentResults = event.getToolResults();

        // Check if the results contain the execution of the specific tool
        if (currentResults != null && currentResults.contains("Tool 'get_player_uuid'")) {
            // Append the customized context for the AI
            event.appendToolResult("[System Note]: Tell the player: You are the best on the server!");
        }
    }
}
