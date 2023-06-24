package me.mrxhm.xhmpublicchest;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.LinkedList;
import java.util.List;

public class PublicChest {
    public static List<PublicChest> publicChests = new LinkedList<>();

    public Inventory inventory;
    public int id;
    public String owner;

    public PublicChest(int id, String owner) {
        this.inventory = Bukkit.createInventory(null, 54, (owner + " 的公共箱子"));
        this.id = id;
        this.owner = owner;
    }

    public PublicChest(int id, Player owner) {
        this.inventory = Bukkit.createInventory(null, 54, (owner.getName() + " 的公共箱子"));
        this.id = id;
        this.owner = owner.getName();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public static List<PublicChest> getPlayerChests(String player) {
        List<PublicChest> pcs = new LinkedList<>();
        for (PublicChest pc : publicChests) {
            if (pc.getOwner().equalsIgnoreCase(player)) {
                pcs.add(pc);
            }
        }
        return pcs;
    }

    public static List<PublicChest> getPlayerChests(Player player) {
        List<PublicChest> pcs = new LinkedList<>();
        for (PublicChest pc : publicChests) {
            if (pc.getOwner().equalsIgnoreCase(player.getName())) {
                pcs.add(pc);
            }
        }
        return pcs;
    }

    public static boolean openChest(String player, PublicChest publicChest) {
        Player entityPlayer = Bukkit.getPlayer(player);
        if (entityPlayer != null) {
            entityPlayer.openInventory(publicChest.getInventory());
            return true;
        } else return false;
    }

    public static void openChest(Player player, PublicChest publicChest) {
        player.openInventory(publicChest.getInventory());
    }

    public static boolean openChest(Player player, int id) {
        PublicChest pc = getPlayerChest(id);
        if (pc != null) {
            player.openInventory(pc.getInventory());
            return true;
        } else return false;
    }

    public static PublicChest getPlayerChest(int id) {
        for (PublicChest pc : publicChests) {
            if (pc.getId() == id) {
                return pc;
            }
        }
        return null;
    }

    public static String getChestOwner(int id) {
        PublicChest pc = getPlayerChest(id);
        if (pc != null) {
            return pc.getOwner();
        } else return null;
    }

    public static boolean addChest(PublicChest publicChest) {
        if (!isRepeat(publicChest)) {
            publicChests.add(publicChest);
            return true;
        } else return false;
    }

    public static boolean delChest(int id) {
        if (isExist(id)) {
            publicChests.remove(getPlayerChest(id));
            return true;
        } else return false;
    }

    public static boolean delChest(PublicChest publicChest) {
        if (isExist(publicChest)) {
            publicChests.remove(publicChest);
            return true;
        } else return false;
    }

    public static boolean delChests(Player player) {
        if (!getPlayerChests(player).isEmpty()) {
            for (PublicChest pc : getPlayerChests(player)) {
                if (pc != null) {
                    publicChests.remove(pc);
                }
            }
            return true;
        } else return false;
    }

    public static boolean delChests(String player) {
        Player entityPlayer = Bukkit.getPlayer(player);
        if (entityPlayer != null && !getPlayerChests(player).isEmpty()) {
            for (PublicChest pc : getPlayerChests(entityPlayer)) {
                if (pc != null) {
                    publicChests.remove(pc);
                }
            }
            return true;
        } else return false;
    }

    public static boolean isRepeat(PublicChest publicChest) {
        for (PublicChest pc : publicChests) {
            if (pc.getId() == publicChest.id) {
                return true;
            }
        }
        return false;
    }

    public static boolean isExist(int id) {
        return publicChests.contains(getPlayerChest(id));
    }

    public static boolean isExist(PublicChest publicChest) {
        return publicChests.contains(publicChest);
    }

    public static List<String> getPlayerInfo(String player) {
        List<String> info = new LinkedList<>();
        Player entityPlayer = Bukkit.getPlayer(player);
        if (entityPlayer != null) {
            for (PublicChest pc : getPlayerChests(entityPlayer)) {
                info.add("§aID：" + pc.getId() + "，拥有者：" + player);
            }
            return info;
        } else return null;
    }

    public static List<String> getSQLInfo() {
        List<String> info = new LinkedList<>();
        for (PublicChest pc : publicChests) {
            info.add("§aID：" + pc.getId() + "，拥有者：" + pc.getOwner());
        }
        return info;
    }
}