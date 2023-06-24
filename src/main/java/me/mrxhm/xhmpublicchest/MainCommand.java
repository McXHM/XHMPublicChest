package me.mrxhm.xhmpublicchest;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class MainCommand implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            int id;
            Player player = (Player) sender;
            if (args.length == 0) {
                if (player.hasPermission("XHMPlugin.xhmpublicchest.open")) {
                    player.openInventory(XHMPublicChest.inv);
                } else player.sendMessage("§c您没权限");
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("list")) {
                    if (player.hasPermission("XHMPlugin.xhmpublicchest.list")) {
                        PluginMsg.printListMsg(sender, PublicChest.getSQLInfo());
                    } else player.sendMessage("§c您没权限");
                }
            } else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("create")) {
                    if (player.hasPermission("XHMPlugin.xhmpublicchest.create")) {
                        if (Pattern.matches("\\d+", args[1])) {
                            id = Integer.parseInt(args[1]);
                            PublicChest pc = new PublicChest(id, player);
                            if (PublicChest.addChest(pc)) {
                                PublicChest.openChest(player, pc);
                                PluginMsg.addChestSuccessfully(sender, id);
                            } else {
                                PluginMsg.addChestFailed(sender, id);
                            }
                        } else PluginMsg.invalidNum(sender, args[1]);
                    } else player.sendMessage("§c您没权限");
                } else if (args[0].equalsIgnoreCase("open")) {
                    if (player.hasPermission("XHMPlugin.xhmpublicchest.open")) {
                        if (Pattern.matches("\\d+", args[1])) {
                            id = Integer.parseInt(args[1]);
                            if (PublicChest.openChest(player, id)) {
                                PluginMsg.openSuccessfully(sender, id);
                            } else {
                                PluginMsg.openFailed(sender, id);
                            }
                        } else PluginMsg.invalidNum(sender, args[1]);
                    } else player.sendMessage("§c您没权限");
                } else if (args[0].equalsIgnoreCase("remove")) {
                    if (player.hasPermission("XHMPlugin.xhmpublicchest.remove")) {
                        if (Pattern.matches("\\d+", args[1])) {
                            id = Integer.parseInt(args[1]);
                            if (PublicChest.delChest(id)) {
                                PluginMsg.delChestSuccessfully(sender, id);
                            } else {
                                PluginMsg.delChestFailed(sender, id);
                            }
                        } else {
                            if (PublicChest.delChests(args[1])) {
                                PluginMsg.delChestsSuccessfully(sender, args[1]);
                            } else PluginMsg.delChestsFailed(sender, args[1]);
                        }
                    } else player.sendMessage("§c您没权限");
                } else if (args[0].equalsIgnoreCase("list")) {
                    if (player.hasPermission("XHMPlugin.xhmpublicchest.list")) {
                        List<String> info = PublicChest.getPlayerInfo(args[1]);
                        if (info != null) {
                            PluginMsg.printListMsg(sender, info);
                        } else PluginMsg.delChestsFailed(sender, args[1]);
                    }
                }
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            return Arrays.asList("create", "open", "remove", "list");
        }
        return null;
    }
}
