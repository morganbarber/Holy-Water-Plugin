package org.holywater.holywater;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class AnvilListener implements Listener {
    @EventHandler
    public void onAnvil(PrepareAnvilEvent event) {
        // get anvil slots
        AnvilInventory inv = event.getInventory();
        ItemStack item1 = inv.getItem(0);
        ItemStack item2 = inv.getItem(1);

        if (item1 != null && item2 != null) {
            // generate key
            NamespacedKey key = new NamespacedKey(String.valueOf(Holy_water.class), "isholywater");
            if (item2.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.BYTE)) {
                // This is holy water!!!
                ItemStack new_item = item1.clone();
                ItemMeta new_meta = new_item.getItemMeta();

                // check if item is holy water type, slightly memory inefficient, BUT VERY SECURE.
                for (Enchantment ench : new_meta.getEnchants().keySet()) {
                    if (ench.equals(Enchantment.BINDING_CURSE)) {
                        // it's a binding curse, remove it
                        new_meta.removeEnchant(ench);
                    } else if (ench.equals(Enchantment.VANISHING_CURSE)) {
                        // it's a vanishing curse, remove it
                        new_meta.removeEnchant(ench);
                    }
                }

                new_item.setItemMeta(new_meta);
                event.setResult(new_item);
            }

        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if(event.getInventory() instanceof AnvilInventory && event.getSlotType() == InventoryType.SlotType.RESULT){
            AnvilInventory inv = (AnvilInventory) event.getInventory();
            ItemStack item1 = inv.getItem(0);
            ItemStack item2 = inv.getItem(1);

            if (item1 != null && item2 != null) {
                // generate key
                NamespacedKey key = new NamespacedKey("holy-water", "isholywater");
                if (item2.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.BYTE) && item2.getAmount() > 1) {
                    event.setCancelled(true);
                    item1.setAmount(item1.getAmount()-1);
                    item2.setAmount(item2.getAmount()-1);
                    inv.setItem(0, item1);
                    inv.setItem(1, item2);
                } else if(item2.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.BYTE) && item2.getAmount() == 1) {
                    event.setCancelled(true);
                    item1.setAmount(item1.getAmount()-1);
                    inv.setItem(0, item1);
                    inv.setItem(1, new ItemStack(Material.AIR));
                }
            }
        }
    }
}
