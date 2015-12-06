package me.TheKawaiiAsian.xReport.utils;

import me.TheKawaiiAsian.xReport.Core;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.UUID;

/**
 * *******************************************************************
 * » Copyright Dylzqn (c) 2015. All rights Reserved.
 * » Any code contained within this document, and any associated APIs with similar branding
 * » are the sole property of Dylzqn. Distribution, reproduction, taking snippets, or
 * » claiming any contents as your own will break the terms of the licence, and void any
 * » agreements with you. the third party.
 * » Thanks :D
 * ********************************************************************
 */
public class ReportManager {

    public void reportPlayer (UUID playerUUID, String reason, UUID reporterUUID) {

        try {
            Core.getMySQL().executeUpdate("INSERT INTO `xReportManager`(`PlayerUUID`, `ReporterUUID`, `ReportReason`) VALUES ('" + playerUUID.toString() + "','" + reporterUUID  + "','" + reason + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Inventory reportInventory (UUID targetUUID) throws Exception {

        Inventory inv = Bukkit.createInventory(null, 18, "§b§lReporting §c" + new NameFetcher(Arrays.asList(targetUUID)).call().toString().replace("{" + targetUUID, "").replace("}", "").replace("=", ""));

        {
            ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ReportTypes.KILLAURA.getName());
            item.setItemMeta(meta);
            inv.setItem(0, item);
        }

        {
            ItemStack item = new ItemStack(Material.GLASS);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ReportTypes.XRAY.getName());
            item.setItemMeta(meta);
            inv.setItem(1, item);
        }

        {
            ItemStack item = new ItemStack(Material.FEATHER);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ReportTypes.NOFALL.getName());
            item.setItemMeta(meta);
            inv.setItem(2, item);
        }

        {
            ItemStack item = new ItemStack(Material.POTION, 1, (short) 8258);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ReportTypes.SPEED.getName());
            item.setItemMeta(meta);
            inv.setItem(3, item);
        }

        {
            ItemStack item = new ItemStack(Material.FEATHER);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ReportTypes.FLY.getName());
            item.setItemMeta(meta);
            inv.setItem(4, item);
        }

        {
            ItemStack item = new ItemStack(Material.PISTON_STICKY_BASE);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ReportTypes.SPIDER.getName());
            item.setItemMeta(meta);
            inv.setItem(5, item);
        }

        {
            ItemStack item = new ItemStack(Material.MUSHROOM_SOUP);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ReportTypes.AUTOSOUP.getName());
            item.setItemMeta(meta);
            inv.setItem(6, item);
        }

        {
            ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ReportTypes.AUTOARMOR.getName());
            item.setItemMeta(meta);
            inv.setItem(7, item);
        }

        {
            ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ReportTypes.AIMBOT.getName());
            item.setItemMeta(meta);
            inv.setItem(8, item);
        }

        {
            ItemStack item = new ItemStack(Material.PAPER);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ReportTypes.OTHER.getName());
            item.setItemMeta(meta);
            inv.setItem(9, item);
        }

        return inv;
    }
}
