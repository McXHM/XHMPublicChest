package me.mrxhm.xhmpublicchest;

import org.bukkit.block.Container;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class MainEvetns implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.getBlock() instanceof Container) {
            event.getPlayer().sendMessage("6");
        } else event.getPlayer().sendMessage("9");
    }
}
