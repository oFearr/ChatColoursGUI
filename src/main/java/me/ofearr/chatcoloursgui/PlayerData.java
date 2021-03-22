package me.ofearr.chatcoloursgui;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.UUID;

public class PlayerData {

    static Main plugin = Main.plugin;
    static File cfile;
    static FileConfiguration config;
    static File df = plugin.getDataFolder();

    public static void create(Player p) {
        cfile = new File(df, "UserData" + File.separator + p.getUniqueId() + ".yml");
        if (!df.exists()) df.mkdir();
        if (!cfile.exists()) {
            try {
                cfile.createNewFile();
                System.out.println("[Crates] Successfully crated userdata file for " + p.getName() + "!");
            } catch(Exception e) {
            }
        }
        config = YamlConfiguration.loadConfiguration(cfile);
    }

    public static void create(OfflinePlayer p) {
        cfile = new File(df, "UserData" + File.separator + p.getUniqueId() + ".yml");
        if (!df.exists()) df.mkdir();
        if (!cfile.exists()) {
            try {
                cfile.createNewFile();
                System.out.println("[Crates] Successfully crated userdata file for " + p.getName() + "!");
            } catch(Exception e) {
            }
        }
        config = YamlConfiguration.loadConfiguration(cfile);
    }


    public static File getfile() {
        return cfile;
    }

    public static void load(Player p) {
        try{
            cfile = new File(df, "UserData" + File.separator + p.getUniqueId() + ".yml");
            config = YamlConfiguration.loadConfiguration(cfile);
        } catch (Exception e){
        }

    }

    public static void load(OfflinePlayer p) {
        cfile = new File(df, "UserData" + File.separator + p.getUniqueId() + ".yml");
        if (!cfile.exists()) {
            try {
                ChatColorEvents.createData(p);
            } catch(Exception e) {
            }
        } else {
            config = YamlConfiguration.loadConfiguration(cfile);
        }
    }

    public static FileConfiguration get() {
        return config;
    }

    public static void save() {
        try {
            config.save(cfile);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
