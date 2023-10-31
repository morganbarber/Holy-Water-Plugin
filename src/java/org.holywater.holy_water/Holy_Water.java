package org.holywater.holywater;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.enchantments.Enchantment;


public final class Holy_water extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("holy water plugin is starting");

        // generate key
        NamespacedKey key = new NamespacedKey("holy-water", "holy_water");

        // initialize recipe
        ShapedRecipe recipe = new ShapedRecipe(key, new HolyWater());
        recipe.shape("#H#", "DWD", "#D#");

        // declare ids as materials
        recipe.setIngredient('#', Material.END_CRYSTAL);
        recipe.setIngredient('H', Material.HEART_OF_THE_SEA);
        recipe.setIngredient('D', Material.DIAMOND);
        recipe.setIngredient('W', Material.WATER_BUCKET);

        // add listeners
        getServer().addRecipe(recipe);
        Bukkit.getPluginManager().registerEvents(new AnvilListener(), this);
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("holy water plugin is disabling");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // on player join logic
        Player player = event.getPlayer();

        // funny custom player join messages
        if (player.getName().equals(".Joebilly1")) {
            Bukkit.broadcastMessage("BOW AND TREMBLE.Joebilly1 HAS JOINED THE SERVER");
        }

        if (player.getName() == "Radeon6900x") {
            Bukkit.broadcastMessage("HIS IMPERIAL MAJESTY HAS JOINED THE SERVER");
        }

        if (player.getName().equals(".Drexseth")) {
            Bukkit.broadcastMessage("HAHAHAHAHAH... NERD!");
        }

        if (player.getName().equals("MiracleInsanity")) {
            Bukkit.broadcastMessage("no steering wheel??");
        }

        if (player.getName().equals("W101_YT")) {
            Bukkit.broadcastMessage("is there someone there? I must have imagined it.");
        }

        if (player.getName().equals("PandasCute23313")) {
            Bukkit.broadcastMessage("you little goblin, when i get my hands on you!");
        }

        event.setJoinMessage("what are you doing here you filthy animal");
    }


    @EventHandler
    public void onW101YTChatted(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        // if will chats, sing western song
        if (player.getName().equals("W101_YT")) {
            Bukkit.broadcastMessage("SWEEEEEET HOME ALABAMA");
        }
    }
}
