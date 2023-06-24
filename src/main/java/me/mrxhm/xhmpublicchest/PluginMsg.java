package me.mrxhm.xhmpublicchest;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class PluginMsg {
    public static void addChestSuccessfully(CommandSender sender, int id) {
        sender.sendMessage("§a成功创造公共箱子，id为：" + id + " ，输入/xpc open " + id + " 打开");
    }

    public static void addChestFailed(CommandSender sender, int id) {
        sender.sendMessage("§c创建失败：重复的id：" + id);
    }

    public static void delChestSuccessfully(CommandSender sender, int id) {
        sender.sendMessage("§a成功删除公共箱子，id为：" + id);
    }

    public static void delChestFailed(CommandSender sender, int id) {
        sender.sendMessage("§c删除失败：重复的id：" + id);
    }

    public static void openSuccessfully(CommandSender sender, int id) {
        sender.sendMessage("§a成功打开玩家 " + PublicChest.getChestOwner(id) + " 的公共箱子");
    }

    public static void openFailed(CommandSender sender, int id) {
        sender.sendMessage("§c未找到箱子ID：" + id);
    }

    public static void invalidNum(CommandSender sender, String id) {
        sender.sendMessage("§c无效的ID：" + id);
    }

    public static void delChestsSuccessfully(CommandSender sender, String player) {
        sender.sendMessage("§a成功删除 " + player + " 的所有公共箱子");
    }

    public static void delChestsFailed(CommandSender sender, String player) {
        sender.sendMessage("§c玩家 " + player + " 不存在或未拥有公共箱子");
    }

    public static void printListMsg(CommandSender sender, List<String> stringList) {
        for (String str : stringList) {
            sender.sendMessage(str);
        }
    }
}
