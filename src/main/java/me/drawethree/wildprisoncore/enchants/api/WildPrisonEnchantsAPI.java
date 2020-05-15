package me.drawethree.wildprisoncore.enchants.api;

import me.drawethree.wildprisoncore.enchants.enchants.WildPrisonEnchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public interface WildPrisonEnchantsAPI {


    HashMap<WildPrisonEnchantment, Integer> getPlayerEnchants(ItemStack itemStack);

    boolean hasEnchant(Player p, int id);

    int getEnchantLevel(ItemStack item, int id);

    boolean addEnchant(ItemStack item, Player p, int id, int level);

    boolean removeEnchnt(Player p, int id);

}
