package me.ofearr.chatcoloursgui.Commands;

import me.ofearr.chatcoloursgui.Inventories.ChatColorsGUI;
import me.ofearr.chatcoloursgui.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatColoursCMD implements CommandExecutor {
    Main plugin = Main.plugin;

    String TranslateColours(String text){
        String converted = ChatColor.translateAlternateColorCodes('&', text);

        return converted;
    }

    String prefix = plugin.getConfig().getString("plugin-prefix");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("chatcolors")){
            if(!(sender instanceof Player)){
                sender.sendMessage(TranslateColours(prefix + " >> &cYou must be a player to issue this command!"));
            } else {
                Player player = (Player) sender;
                if(player.hasPermission("chatcolorsgui.gui")){
                    player.openInventory(ChatColorsGUI.GUI(player));
                } else {
                    player.sendMessage(TranslateColours(plugin.getConfig().getString("insufficient-permissions-message").replace("{prefix}", prefix)));
                }


            }
        }
        return false;
    }
}
