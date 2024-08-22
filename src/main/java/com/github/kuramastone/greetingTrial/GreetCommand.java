package com.github.kuramastone.greetingTrial;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.jetbrains.annotations.NotNull;

public class GreetCommand implements CommandExecutor {

    private GreetingPlugin api;

    public GreetCommand(GreetingPlugin api) {
        this.api = api;
        register();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(command.getName().equalsIgnoreCase("greet")) {
            String response = api.getMessageConfig().get("greet.response");
            response = response.replace("{player}", sender.getName());
            sender.sendMessage(response);
        }

        return false;
    }

    private void register() {
        PluginCommand cmd = api.getCommand("greet");
        cmd.setExecutor(this);
    }
}
