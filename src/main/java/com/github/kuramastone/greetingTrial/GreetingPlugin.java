package com.github.kuramastone.greetingTrial;

import org.bukkit.plugin.java.JavaPlugin;

public final class GreetingPlugin extends JavaPlugin {

    private ConfigMessages messageConfig;

    @Override
    public void onEnable() {
        loadConfig();

        // register commands
        new GreetCommand(this);
    }

    private void loadConfig() {
        // the native yaml reader is great, but I use this across my projects for consistent usage
        YamlReader config = new YamlReader(this, "config.yml");
        // ensures that the default messages are re-added if removed
        config.installNewKeysFromDefault("messages");

        // store the messages here
        messageConfig = new ConfigMessages();
        messageConfig.load(config);
    }

    public ConfigMessages getMessageConfig() {
        return messageConfig;
    }

}
