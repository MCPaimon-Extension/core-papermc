# MCAI Core Extension (PaperMC)

The Core extension for MCAI provides the essential tools, commands, and listeners required for the AI framework to function on a PaperMC server. It handles account management, system configuration, and real-time AI chat interactions.

## Features

- **Dynamic Command System**: Registers the `/ai` (alias `/mcai`) command for players and console without requiring `plugin.yml` entries.
- **Account Management Tools**: Tools for setting, changing, getting, and deleting AI API tokens for different account types (players, console, etc.).
- **System Configuration Tools**: Tools for registering new AI platforms and models into the system dynamically.
- **Interactive AI Chat Mode**: A high-priority chat listener that enables a dedicated chat mode for players to talk directly with the AI.
- **Dynamic Categories**: Automatically creates management categories for tools in the MCAI system.

## Commands

- `/ai ask <prompt>`: Send a direct question to the AI.
- `/ai chat`: Toggle AI Chat Mode (Players only). Type `quit` or `exit` to end the session.
- `/ai active set <platform> <model>`: Set the active AI platform and model for your session.
- `/ai token set <platform> <token>`: Set your API token for a specific platform.
- `/ai help`: Display the help menu.

## AI Tools Registered

This extension registers the following tools to the MCAI system:

- `set_token`: Sets an AI token for an account.
- `change_token`: Changes an existing AI token.
- `get_token`: Retrieves the token status for an account.
- `delete_token`: Removes a token from an account.
- `create_platform`: Registers a new AI platform (Requires OP).
- `create_model`: Registers a new model for a platform (Requires OP).

## Installation

1. Ensure the [MCAI Plugin](https://github.com/MCPaimon/plugin) is installed on your PaperMC server.
2. Place the compiled `CorePaperMC-*.jar` into the following directory:
   ```
   plugins\MCAI\extensions\libs
   ```
3. Restart the server or reload the extension manager.

## Requirements

- **Java**: 25+
- **PaperMC**: 26.1.2+
- **MCAI Plugin**: Latest version

## Build Instructions

To build the extension from source:
```bash
./gradlew build
```
The compiled artifact will be located in `build/libs/`.
