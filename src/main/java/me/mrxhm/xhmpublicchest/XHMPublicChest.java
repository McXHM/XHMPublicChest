package me.mrxhm.xhmpublicchest;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public final class XHMPublicChest extends JavaPlugin {
    public static Inventory inv = Bukkit.createInventory(null, 54, "公共箱子");
    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("xhmpublicchest").setExecutor(new MainCommand());
//        getServer().getPluginManager().registerEvents(new MainEvetns(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
