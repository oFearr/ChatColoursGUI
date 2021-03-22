package me.ofearr.chatcoloursgui;

import me.ofearr.chatcoloursgui.Commands.ChatColoursCMD;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class Main extends JavaPlugin {

    public static Main plugin;
    public static HashMap<UUID, String> enabledColor = new HashMap<>();

    @Override
    public void onEnable() {
        plugin = this;
       loadConfig();
       getCommand("chatcolors").setExecutor(new ChatColoursCMD());
        Bukkit.getPluginManager().registerEvents(new ChatColorEvents(), this);
    }

    @Override
    public void onDisable(){
        for(Player p : Bukkit.getOnlinePlayers()){
            ChatColorEvents.writeDataToFile(p);
        }
        System.out.println("[ChatColorGUI] Successfully saved all user data to files!");
    }

    public void loadConfig(){
        saveDefaultConfig();
    }
}
