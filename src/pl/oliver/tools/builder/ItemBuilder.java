package pl.oliver.tools.builder;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.oliver.tools.helper.ChatHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemBuilder {
    private final Material material;
    private String title;
    private List<String> lore = new ArrayList<>();
    private short data;
    private int amount = 1;
    private final Map<Enchantment, Integer> enchantments = new HashMap<>();

    public ItemBuilder(Material material) {
        this.material = material;
    }
    public ItemBuilder(Material material, int amount) {
        this.material = material;
        this.amount = amount;
    }
    public ItemBuilder(Material material, short data) {
        this.material = material;
        this.data = data;
    }
    public ItemBuilder(Material material, int amount, short data) {
        this.material = material;
        this.amount = amount;
        this.data = data;
    }
    public ItemBuilder addEnchantment(Enchantment enchantment, int lvl) {
        enchantments.put(enchantment, lvl);
        return this;
    }
    public ItemBuilder setEnchantments(Map<Enchantment, Integer> enchantments) {
        if(enchantments != null) {
            this.enchantments.putAll(enchantments);
        }
        return this;
    }

    public ItemBuilder setTitle(String title) {
        this.title = ChatHelper.fixColor(title);
        return this;
    }

    public ItemBuilder addLore(String lore) {
        this.lore.add(ChatHelper.fixColor(lore));
        return this;
    }
    public ItemBuilder setLore(List<String> lore) {
        this.lore = lore;
        return this;
    }

    public ItemStack build() {
        ItemStack itemStack = new ItemStack(this.material, amount, data);
            itemStack.addEnchantments(enchantments);

        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(this.title == null ? "" : this.title);
        itemMeta.setLore(this.lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
