package me.TheKawaiiAsian.xReport.utils;

import me.TheKawaiiAsian.xReport.Core;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public void reportPlayer(Player player, Player reporter, String reason) {

        try {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

            Core.getMySQL().executeUpdate("INSERT INTO `xReportManager`(`PlayerUUID`, `PlayerName`, `ReporterUUID`, `ReporterName`, `ReportReason`, `ReportTime`) VALUES ('" + player.getUniqueId().toString() + "','" + player.getName() + "','" + reporter.getUniqueId().toString() + "','" + reporter.getName() + "','" + reason + "','" + simpleDateFormat.format(date) + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String[] getLatestReports() {

        String[] array = new String[10];

        try {
            ResultSet rs = Core.getMySQL().getResultSet("SELECT * FROM `xReportManager` ORDER BY CONVERT(ID, UNSIGNED INTEGER) DESC LIMIT 10");

            for (int ex = 0; rs.next(); ex++) {
                array[ex] = ("§bID: §r" + rs.getString("ID") + " §7§l| §6Player: §r" + rs.getString("PlayerName") + " §7§l| §bReport: §r" + rs.getString("ReportReason") + " §7§l| §6ReporterName: §r" + rs.getString("ReporterName") + " §7§l| §bReport Time: §r" + rs.getString("ReportTime") + "\n\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return array;
    }

    public String getReport (Integer ID) {

        try {
            ResultSet rs = Core.getMySQL().getResultSet("SELECT * FROM `xReportManager` WHERE ID='" + ID + "'");

            if (rs.next()) {
                return ("§6Player: §r" + rs.getString("PlayerName") + " §7§l| §bReport: §r" + rs.getString("ReportReason") + " §7§l| §6ReporterName: §r" + rs.getString("ReporterName") + " §7§l| §bReport Time: §r" + rs.getString("ReportTime"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "§4§l>> §cReport not found. c ";
    }



    public Inventory reportInventory (Player player) {

        Inventory inv = Bukkit.createInventory(null, 18, "§b§lReporting §c" + player.getName());

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
