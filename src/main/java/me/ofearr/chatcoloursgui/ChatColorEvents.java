package me.ofearr.chatcoloursgui;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;

public class ChatColorEvents implements Listener {

    static String TranslateColours(String text){
        String converted = ChatColor.translateAlternateColorCodes('&', text);

        return converted;
    }

    static Main plugin = Main.plugin;

    @EventHandler
    public static void applyChatColor(AsyncPlayerChatEvent e){
        Player player = e.getPlayer();
        String msg = e.getMessage();
        String color = "";
        String addition = "";

        String completeMessage = "";
        if(Main.enabledColor.get(player.getUniqueId()) == "black"){
            color = ChatColor.BLACK + "";
        } else if(Main.enabledColor.get(player.getUniqueId()) == "dark_blue"){
            color = ChatColor.DARK_BLUE + "";
        } else if(Main.enabledColor.get(player.getUniqueId()) == "dark_green"){
            color = ChatColor.DARK_GREEN + "";
        } else if(Main.enabledColor.get(player.getUniqueId()) == "cyan"){
            color = ChatColor.DARK_AQUA + "";
        } else if(Main.enabledColor.get(player.getUniqueId()) == "dark_red"){
            color = ChatColor.DARK_RED + "";
        } else if(Main.enabledColor.get(player.getUniqueId()) == "purple"){
            color = ChatColor.DARK_PURPLE + "";
        } else if(Main.enabledColor.get(player.getUniqueId()) == "gold"){
            color = ChatColor.GOLD + "";
        } else if(Main.enabledColor.get(player.getUniqueId()) == "gray"){
            color = ChatColor.GRAY + "";
        } else if(Main.enabledColor.get(player.getUniqueId()) == "blue"){
            color = ChatColor.BLUE + "";
        } else if(Main.enabledColor.get(player.getUniqueId()) == "green"){
            color = ChatColor.GREEN + "";
        } else if(Main.enabledColor.get(player.getUniqueId()) == "aqua"){
            color = ChatColor.AQUA + "";
        } else if(Main.enabledColor.get(player.getUniqueId()) == "red"){
            color = ChatColor.RED + "";
        } else if(Main.enabledColor.get(player.getUniqueId()) == "pink"){
            color = ChatColor.LIGHT_PURPLE + "";
        } else if(Main.enabledColor.get(player.getUniqueId()) == "yellow"){
            color = ChatColor.YELLOW + "";
        } else if(Main.enabledColor.get(player.getUniqueId()) == "white"){
            color = ChatColor.WHITE + "";
        } if(Main.enabledAddon.get(player.getUniqueId()) == "bold"){
            addition = ChatColor.BOLD + "";
        } else {
            e.setMessage(msg);
            return;
        }

        completeMessage = color + addition + msg;
        e.setMessage(completeMessage);

    }

    @EventHandler
    public static void selectChatColor(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();

        ItemStack item = e.getCurrentItem();


        if(e.getSlotType() == InventoryType.SlotType.OUTSIDE) return;
        if(e.getCurrentItem() == null) return;

        String title = plugin.getConfig().getString("gui-title");

        if(e.getView().getTitle().equalsIgnoreCase(TranslateColours(title))){

            if(!item.hasItemMeta()){
                e.setCancelled(true);
                return;
            }

            if(!item.getItemMeta().hasLore()){
                e.setCancelled(true);
                return;
            }

            String itemName = item.getItemMeta().getDisplayName();

            if(itemName.contains("Black") && player.hasPermission("chatcolorsgui.black")){
                Main.enabledColor.put(player.getUniqueId(), "black");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Dark Blue") && player.hasPermission("chatcolorsgui.darkblue")){
                Main.enabledColor.put(player.getUniqueId(), "dark_blue");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Dark Green") && player.hasPermission("chatcolorsgui.darkgreen")){
                Main.enabledColor.put(player.getUniqueId(), "dark_green");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Cyan") && player.hasPermission("chatcolorsgui.cyan")){
                Main.enabledColor.put(player.getUniqueId(), "cyan");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Dark Red") && player.hasPermission("chatcolorsgui.darkred")){
                Main.enabledColor.put(player.getUniqueId(), "dark_red");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Purple") && player.hasPermission("chatcolorsgui.purple")){
                Main.enabledColor.put(player.getUniqueId(), "purple");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Gold") && player.hasPermission("chatcolorsgui.gold")){
                Main.enabledColor.put(player.getUniqueId(), "gold");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Gray") && player.hasPermission("chatcolorsgui.gray")){
                Main.enabledColor.put(player.getUniqueId(), "gray");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Dark Gray")&& player.hasPermission("chatcolorsgui.darkgray")){
                Main.enabledColor.put(player.getUniqueId(), "dark_gray");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Blue") && player.hasPermission("chatcolorsgui.blue")){
                Main.enabledColor.put(player.getUniqueId(), "blue");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Green") && player.hasPermission("chatcolorsgui.green")){
                Main.enabledColor.put(player.getUniqueId(), "green");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Aqua") && player.hasPermission("chatcolorsgui.aqua")){
                Main.enabledColor.put(player.getUniqueId(), "aqua");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Red") && player.hasPermission("chatcolorsgui.red")){
                Main.enabledColor.put(player.getUniqueId(), "red");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Pink") && player.hasPermission("chatcolorsgui.pink")){
                Main.enabledColor.put(player.getUniqueId(), "pink");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Yellow") && player.hasPermission("chatcolorsgui.yellow")){
                Main.enabledColor.put(player.getUniqueId(), "yellow");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("White") && player.hasPermission("chatcolorsgui.white")){
                Main.enabledColor.put(player.getUniqueId(), "white");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            }

            e.setCancelled(true);
        }
    }
}
