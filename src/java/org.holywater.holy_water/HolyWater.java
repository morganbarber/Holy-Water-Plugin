package org.holywater.holy_water;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class HolyWater extends ItemStack {
    public HolyWater() {
        // initialize HolyWater as child of experience bottles
        super(Material.EXPERIENCE_BOTTLE);
        ItemMeta meta = getItemMeta();

        // secure measurements to for item checking
        NamespacedKey key = new NamespacedKey("holy-water", "isHolyWater");
        meta.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 1);

        // title
        meta.setDisplayName(ChatColor.AQUA + "Holy Water");

        // lore
        List<String> lore = new ArrayList<>();
        lore.add("Sacred Elixir, shimmering with divine purity.");
        lore.add("Banishes the shadow of curses, restoring items to their untarnished essence.");
        meta.setLore(lore);
        setItemMeta(meta);
    }
}
