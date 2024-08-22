package com.github.kuramastone.greetingTrial;

import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.Map;


public class ConfigMessages {

    private Map<String, String> messageByKey;

    public ConfigMessages() {
        messageByKey = new HashMap<>();
    }

    /*
    Load keys under this section. Add all to the map for later access.
     */
    public void load(YamlReader config) {
        for(String mapKey : config.getKeys("messages", true)) {
            String yamlKey = "messages." + mapKey;
            if(config.isSection(yamlKey)) {
                continue;
            }
            System.out.println(yamlKey);
            String msg = config.getString(yamlKey);
            msg = ChatColor.translateAlternateColorCodes('&', msg);
            messageByKey.put(mapKey, msg);
        }
    }

    public String get(String key) {
        return this.messageByKey.get(key);
    }

}
