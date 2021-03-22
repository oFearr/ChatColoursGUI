package me.ofearr.chatcoloursgui;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class ChatColorEvents implements Listener {

    static String TranslateColours(String text){
        String converted = ChatColor.translateAlternateColorCodes('&', text);

        return converted;
    }

    static Main plugin = Main.plugin;

    public static void collectDataFromFile(Player player){
        createData(player);
        PlayerData.load(player);
        Main.enabledColor.put(player.getUniqueId(), PlayerData.get().getString("enabled"));
    }

    public static void writeDataToFile(Player player){
        PlayerData.load(player);
        PlayerData.get().set("enabled", Main.enabledColor.get(player.getUniqueId()));
        PlayerData.save();
    }

    public static void createData(Player player){
        PlayerData.create(player);
        PlayerData.load(player);
        if(PlayerData.get().getString("enabled") == null){
            PlayerData.get().set("enabled", plugin.getConfig().getString("default-color"));
            PlayerData.save();
        }

    }

    public static void createData(OfflinePlayer player){
        PlayerData.create(player);
        PlayerData.load(player);
        if(PlayerData.get().getString("enabled") == null){
            PlayerData.get().set("enabled", plugin.getConfig().getString("default-color"));
            PlayerData.save();
        }
    }

    @EventHandler
    public void onLogIn(PlayerJoinEvent e){
        Player player = e.getPlayer();
        collectDataFromFile(player);
    }

    @EventHandler
    public void onLogOut(PlayerJoinEvent e){
        Player player = e.getPlayer();
        writeDataToFile(player);
    }

    @EventHandler
    public static void applyChatColor(AsyncPlayerChatEvent e){
        Player player = e.getPlayer();
        String msg = e.getMessage();
        String coloredMessage = "";
        if(Main.enabledColor.get(player.getUniqueId()) == "black"){
            coloredMessage = ChatColor.BLACK + msg;
        } else if(Main.enabledColor.get(player.getUniqueId()) == "dark_blue"){
            coloredMessage = ChatColor.DARK_BLUE + msg;
        } else if(Main.enabledColor.get(player.getUniqueId()) == "dark_green"){
            coloredMessage = ChatColor.DARK_GREEN + msg;
        } else if(Main.enabledColor.get(player.getUniqueId()) == "cyan"){
            coloredMessage = ChatColor.DARK_AQUA + msg;
        } else if(Main.enabledColor.get(player.getUniqueId()) == "dark_red"){
            coloredMessage = ChatColor.DARK_RED + msg;
        } else if(Main.enabledColor.get(player.getUniqueId()) == "purple"){
            coloredMessage = ChatColor.DARK_PURPLE + msg;
        } else if(Main.enabledColor.get(player.getUniqueId()) == "gold"){
            coloredMessage = ChatColor.GOLD + msg;
        } else if(Main.enabledColor.get(player.getUniqueId()) == "gray"){
            coloredMessage = ChatColor.GRAY + msg;
        } else if(Main.enabledColor.get(player.getUniqueId()) == "blue"){
            coloredMessage = ChatColor.BLUE + msg;
        } else if(Main.enabledColor.get(player.getUniqueId()) == "green"){
            coloredMessage = ChatColor.GREEN + msg;
        } else if(Main.enabledColor.get(player.getUniqueId()) == "aqua"){
            coloredMessage = ChatColor.AQUA + msg;
        } else if(Main.enabledColor.get(player.getUniqueId()) == "red"){
            coloredMessage = ChatColor.RED + msg;
        } else if(Main.enabledColor.get(player.getUniqueId()) == "pink"){
            coloredMessage = ChatColor.LIGHT_PURPLE + msg;
        } else if(Main.enabledColor.get(player.getUniqueId()) == "yellow"){
            coloredMessage = ChatColor.YELLOW + msg;
        } else if(Main.enabledColor.get(player.getUniqueId()) == "white"){
            coloredMessage = ChatColor.WHITE + msg;
        }
        e.setMessage(coloredMessage);

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

            if(itemName.contains("Black") && player.hasPermission("chatcoloursgui.black")){
                Main.enabledColor.put(player.getUniqueId(), "black");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Dark Blue") && player.hasPermission("chatcoloursgui.darkblue")){
                Main.enabledColor.put(player.getUniqueId(), "dark_blue");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Dark Green") && player.hasPermission("chatcoloursgui.darkgreen")){
                Main.enabledColor.put(player.getUniqueId(), "dark_green");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Cyan") && player.hasPermission("chatcoloursgui.cyan")){
                Main.enabledColor.put(player.getUniqueId(), "cyan");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Dark Red") && player.hasPermission("chatcoloursgui.darkred")){
                Main.enabledColor.put(player.getUniqueId(), "dark_red");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Purple") && player.hasPermission("chatcoloursgui.purple")){
                Main.enabledColor.put(player.getUniqueId(), "purple");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Gold") && player.hasPermission("chatcoloursgui.gold")){
                Main.enabledColor.put(player.getUniqueId(), "gold");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Gray") && player.hasPermission("chatcoloursgui.gray")){
                Main.enabledColor.put(player.getUniqueId(), "gray");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Dark Gray")&& player.hasPermission("chatcoloursgui.darkgray")){
                Main.enabledColor.put(player.getUniqueId(), "dark_gray");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Blue") && player.hasPermission("chatcoloursgui.blue")){
                Main.enabledColor.put(player.getUniqueId(), "blue");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Green") && player.hasPermission("chatcoloursgui.green")){
                Main.enabledColor.put(player.getUniqueId(), "green");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Aqua") && player.hasPermission("chatcoloursgui.aqua")){
                Main.enabledColor.put(player.getUniqueId(), "aqua");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Red") && player.hasPermission("chatcoloursgui.red")){
                Main.enabledColor.put(player.getUniqueId(), "red");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Pink") && player.hasPermission("chatcoloursgui.pink")){
                Main.enabledColor.put(player.getUniqueId(), "pink");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("Yellow") && player.hasPermission("chatcoloursgui.yellow")){
                Main.enabledColor.put(player.getUniqueId(), "yellow");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            } else if(itemName.contains("White") && player.hasPermission("chatcoloursgui.white")){
                Main.enabledColor.put(player.getUniqueId(), "white");
                String setMessage = plugin.getConfig().getString("set-chat-color-msg").replace("{color}", Main.enabledColor.get(player.getUniqueId())).replace("{prefix}", plugin.getConfig().getString("plugin-prefix"));
                player.sendMessage(TranslateColours(setMessage));
            }

            e.setCancelled(true);
        }
    }
}
