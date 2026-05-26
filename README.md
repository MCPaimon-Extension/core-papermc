# MCPaimon Template Extension

This module serves as a boilerplate and starting point for developers who want to create their own custom extensions and tools for the MCPaimon AI Plugin.

## Features & AI Tools

This template includes basic examples of how to register custom tools to the MCPaimon manager:

* **`get_player_name`**: A simple tool that returns the name of the player interacting with the AI.
* **`get_player_uuid`**: A simple tool that returns the UUID of the player interacting with the AI.

## How to Use
1. Copy this template directory to start your new extension project.
2. Update the `settings.gradle` and `gradle.properties` files with your project's name and group ID.
3. Rename the main class and update the `src/main/resources/extension.yml` accordingly.
4. Implement your custom tools by implementing the `AITool` interface and register them in your main extension class using `mcaiPlugin.getManager().registerTool(new YourCustomTool())`.

## Requirements
* Java 25
* PaperMC 1.21+ (Paper API 26.1.2)
* MCPaimon AI Plugin Core

## Build Instructions
To build the extension, use the included Gradle wrapper:
```bash
./gradlew build
```

The compiled artifact will be located in `build/libs/`.
