package me.ofearr.chatcoloursgui.Inventories;

import me.ofearr.chatcoloursgui.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ChatColorsGUI {

    static Main plugin = Main.plugin;

    static String TranslateColours(String text){
        String converted = ChatColor.translateAlternateColorCodes('&', text);

        return converted;
    }

    static String version = Bukkit.getServer().getVersion();

    public static boolean isLegacy(){
        if (version.contains("1.13")) {
            return false;
        } else if (version.contains("1.14")) {
            return false;
        } else if (version.contains("1.15")) {
            return false;
        } else if (version.contains("1.16")) {
            return false;
        } else{
            return true;
        }
    }

    static String title = plugin.getConfig().getString("gui-title");

    @SuppressWarnings("deprecation")
    public static Inventory GUI(Player player){

        Inventory inv = Bukkit.createInventory(null, 18, TranslateColours(title));

        ItemStack black = null;
        ItemStack dark_blue = null;
        ItemStack dark_green = null;
        ItemStack cyan = null;
        ItemStack dark_red = null;
        ItemStack purple = null;
        ItemStack gold = null;
        ItemStack gray = null;
        ItemStack dark_gray = null;
        ItemStack blue = null;
        ItemStack green = null;
        ItemStack aqua = null;
        ItemStack red = null;
        ItemStack pink = null;
        ItemStack yellow = null;
        ItemStack white = null;

        if(isLegacy()) {
            black = new ItemStack(Material.getMaterial("STAINED_GLASS_PANE"), 1, (short) 15);
            dark_blue = new ItemStack(Material.getMaterial("STAINED_GLASS_PANE"), 1, (short) 11);
            dark_green = new ItemStack(Material.getMaterial("STAINED_GLASS_PANE"), 1, (short) 13);
            cyan = new ItemStack(Material.getMaterial("STAINED_GLASS_PANE"), 1, (short) 9);
            dark_red = new ItemStack(Material.getMaterial("STAINED_GLASS_PANE"), 1, (short) 14);
            purple = new ItemStack(Material.getMaterial("STAINED_GLASS_PANE"), 1, (short) 15);
            gold = new ItemStack(Material.getMaterial("STAINED_GLASS_PANE"), 1, (short) 1);
            gray = new ItemStack(Material.getMaterial("STAINED_GLASS_PANE"), 1, (short) 8);
            dark_gray = new ItemStack(Material.getMaterial("STAINED_GLASS_PANE"), 1, (short) 7);
            blue = new ItemStack(Material.getMaterial("STAINED_GLASS_PANE"), 1, (short) 11);
            green = new ItemStack(Material.getMaterial("STAINED_GLASS_PANE"), 1, (short) 5);
            aqua = new ItemStack(Material.getMaterial("STAINED_GLASS_PANE"), 1, (short) 9);
            red = new ItemStack(Material.getMaterial("STAINED_GLASS_PANE"), 1, (short) 14);
            pink = new ItemStack(Material.getMaterial("STAINED_GLASS_PANE"), 1, (short) 6);
            yellow = new ItemStack(Material.getMaterial("STAINED_GLASS_PANE"), 1, (short) 4);
            white = new ItemStack(Material.getMaterial("STAINED_GLASS_PANE"), 1, (short) 0);
        } else {
            black = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
            dark_blue = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
            dark_green = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            cyan = new ItemStack(Material.CYAN_STAINED_GLASS_PANE);
            dark_red = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            purple = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
            gold = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
            gray = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
            dark_gray = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            blue = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
            green = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
            aqua = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
            red = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            pink = new ItemStack(Material.PINK_STAINED_GLASS_PANE);
            yellow = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
            white = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        }

            ItemMeta blackMeta = black.getItemMeta();
            blackMeta.setDisplayName(TranslateColours("&0Black Chat Color"));
            List<String> blackLore = new ArrayList<>();
            if(player.hasPermission("chatcoloursgui.black")){
                blackLore.add(TranslateColours(plugin.getConfig().getString("has-color-lore")));
            } else {
                blackLore.add(TranslateColours(plugin.getConfig().getString("not-have-color-lore")));
            }
            blackMeta.setLore(blackLore);
            black.setItemMeta(blackMeta);

            ItemMeta dbMeta = dark_blue.getItemMeta();
            dbMeta.setDisplayName(TranslateColours("&1Dark Blue Chat Color"));
            List<String> dbLore = new ArrayList<>();
            if(player.hasPermission("chatcoloursgui.darkblue")){
                dbLore.add(TranslateColours(plugin.getConfig().getString("has-color-lore")));
            } else {
                dbLore.add(TranslateColours(plugin.getConfig().getString("not-have-color-lore")));
            }
            dbMeta.setLore(dbLore);
            dark_blue.setItemMeta(dbMeta);

            ItemMeta dark_greenMeta = dark_green.getItemMeta();
            dark_greenMeta.setDisplayName(TranslateColours("&2Dark Green Chat Color"));
            List<String> dark_greenLore = new ArrayList<>();
            if(player.hasPermission("chatcoloursgui.darkgreen")){
                dark_greenLore.add(TranslateColours(plugin.getConfig().getString("has-color-lore")));
            } else {
                dark_greenLore.add(TranslateColours(plugin.getConfig().getString("not-have-color-lore")));
            }
            dark_greenMeta.setLore(dark_greenLore);
            dark_green.setItemMeta(dark_greenMeta);

            ItemMeta cyanMeta = cyan.getItemMeta();
            cyanMeta.setDisplayName(TranslateColours("&3Cyan Chat Color"));
            List<String> cyanLore = new ArrayList<>();
            if(player.hasPermission("chatcoloursgui.cyan")){
                cyanLore.add(TranslateColours(plugin.getConfig().getString("has-color-lore")));
            } else {
                cyanLore.add(TranslateColours(plugin.getConfig().getString("not-have-color-lore")));
            }
            cyanMeta.setLore(cyanLore);
            cyan.setItemMeta(cyanMeta);

            ItemMeta dark_redMeta = dark_red.getItemMeta();
            dark_redMeta.setDisplayName(TranslateColours("&4Dark Red Chat Color"));
            List<String> dark_redLore = new ArrayList<>();
            if(player.hasPermission("chatcoloursgui.darkred")){
                dark_redLore.add(TranslateColours(plugin.getConfig().getString("has-color-lore")));
            } else {
                dark_redLore.add(TranslateColours(plugin.getConfig().getString("not-have-color-lore")));
            }
            dark_redMeta.setLore(dark_redLore);
            dark_red.setItemMeta(dark_redMeta);

            ItemMeta purpleMeta = purple.getItemMeta();
            purpleMeta.setDisplayName(TranslateColours("&5Purple Chat Color"));
            List<String> purpleLore = new ArrayList<>();
            if(player.hasPermission("chatcoloursgui.purple")){
                purpleLore.add(TranslateColours(plugin.getConfig().getString("has-color-lore")));
            } else {
                purpleLore.add(TranslateColours(plugin.getConfig().getString("not-have-color-lore")));
            }
            purpleMeta.setLore(purpleLore);
            purple.setItemMeta(purpleMeta);

            ItemMeta goldMeta = gold.getItemMeta();
            goldMeta.setDisplayName(TranslateColours("&6Gold Chat Color"));
            List<String> goldLore = new ArrayList<>();
            if(player.hasPermission("chatcoloursgui.gold")){
                goldLore.add(TranslateColours(plugin.getConfig().getString("has-color-lore")));
            } else {
                goldLore.add(TranslateColours(plugin.getConfig().getString("not-have-color-lore")));
            }
            goldMeta.setLore(goldLore);
            gold.setItemMeta(goldMeta);

            ItemMeta grayMeta = gray.getItemMeta();
            grayMeta.setDisplayName(TranslateColours("&7Gray Chat Color"));
            List<String> grayLore = new ArrayList<>();
            if(player.hasPermission("chatcoloursgui.gray")){
                grayLore.add(TranslateColours(plugin.getConfig().getString("has-color-lore")));
            } else {
                grayLore.add(TranslateColours(plugin.getConfig().getString("not-have-color-lore")));
            }
            grayMeta.setLore(grayLore);
            gray.setItemMeta(grayMeta);

            ItemMeta dark_grayMeta = dark_gray.getItemMeta();
            dark_grayMeta.setDisplayName(TranslateColours("&8Dark Gray Chat Color"));
            List<String> dark_grayLore = new ArrayList<>();
            if(player.hasPermission("chatcoloursgui.darkgray")){
                dark_grayLore.add(TranslateColours(plugin.getConfig().getString("has-color-lore")));
            } else {
                dark_grayLore.add(TranslateColours(plugin.getConfig().getString("not-have-color-lore")));
            }
            dark_grayMeta.setLore(dark_grayLore);
            dark_gray.setItemMeta(dark_grayMeta);

            ItemMeta blueMeta = blue.getItemMeta();
            blueMeta.setDisplayName(TranslateColours("&9Blue Chat Color"));
            List<String> blueLore = new ArrayList<>();
            if(player.hasPermission("chatcoloursgui.blue")){
                blueLore.add(TranslateColours(plugin.getConfig().getString("has-color-lore")));
            } else {
                blueLore.add(TranslateColours(plugin.getConfig().getString("not-have-color-lore")));
            }
            blueMeta.setLore(blueLore);
            blue.setItemMeta(blueMeta);

            ItemMeta greenMeta = green.getItemMeta();
            greenMeta.setDisplayName(TranslateColours("&aGreen Chat Color"));
            List<String> greenLore = new ArrayList<>();
            if(player.hasPermission("chatcoloursgui.green")){
                greenLore.add(TranslateColours(plugin.getConfig().getString("has-color-lore")));
            } else {
                greenLore.add(TranslateColours(plugin.getConfig().getString("not-have-color-lore")));
            }
            greenMeta.setLore(greenLore);
            green.setItemMeta(greenMeta);

            ItemMeta aquaMeta = aqua.getItemMeta();
            aquaMeta.setDisplayName(TranslateColours("&bAqua Chat Color"));
            List<String> aquaLore = new ArrayList<>();
            if(player.hasPermission("chatcoloursgui.aqua")){
                aquaLore.add(TranslateColours(plugin.getConfig().getString("has-color-lore")));
            } else {
                aquaLore.add(TranslateColours(plugin.getConfig().getString("not-have-color-lore")));
            }
            aquaMeta.setLore(aquaLore);
            aqua.setItemMeta(aquaMeta);

            ItemMeta redMeta = red.getItemMeta();
            redMeta.setDisplayName(TranslateColours("&cRed Chat Color"));
            List<String> redLore = new ArrayList<>();
            if(player.hasPermission("chatcoloursgui.red")){
                redLore.add(TranslateColours(plugin.getConfig().getString("has-color-lore")));
            } else {
                redLore.add(TranslateColours(plugin.getConfig().getString("not-have-color-lore")));
            }
            redMeta.setLore(redLore);
            red.setItemMeta(redMeta);

            ItemMeta pinkMeta = pink.getItemMeta();
            pinkMeta.setDisplayName(TranslateColours("&dPink Chat Color"));
            List<String> pinkLore = new ArrayList<>();
            if(player.hasPermission("chatcoloursgui.pink")){
                pinkLore.add(TranslateColours(plugin.getConfig().getString("has-color-lore")));
            } else {
                pinkLore.add(TranslateColours(plugin.getConfig().getString("not-have-color-lore")));
            }
            pinkMeta.setLore(pinkLore);
            pink.setItemMeta(pinkMeta);

            ItemMeta yellowMeta = yellow.getItemMeta();
            yellowMeta.setDisplayName(TranslateColours("&eYellow Chat Color"));
            List<String> yellowLore = new ArrayList<>();
            if(player.hasPermission("chatcoloursgui.yellow")){
                yellowLore.add(TranslateColours(plugin.getConfig().getString("has-color-lore")));
            } else {
                yellowLore.add(TranslateColours(plugin.getConfig().getString("not-have-color-lore")));
            }
            yellowMeta.setLore(yellowLore);
            yellow.setItemMeta(yellowMeta);

            ItemMeta whiteMeta = white.getItemMeta();
            whiteMeta.setDisplayName(TranslateColours("&fWhite Chat Color"));
            List<String> whiteLore = new ArrayList<>();
            if(player.hasPermission("chatcoloursgui.white")){
                whiteLore.add(TranslateColours(plugin.getConfig().getString("has-color-lore")));
            } else {
                whiteLore.add(TranslateColours(plugin.getConfig().getString("not-have-color-lore")));
            }
            whiteMeta.setLore(whiteLore);
            white.setItemMeta(whiteMeta);

            inv.addItem(black);
            inv.addItem(white);
            inv.addItem(dark_blue);
            inv.addItem(dark_green);
            inv.addItem(cyan);
            inv.addItem(dark_red);
            inv.addItem(purple);
            inv.addItem(gold);
            inv.addItem(gray);
            inv.addItem(dark_gray);
            inv.addItem(blue);
            inv.addItem(green);
            inv.addItem(aqua);
            inv.addItem(red);
            inv.addItem(pink);
            inv.addItem(yellow);

        return inv;
    }
}
