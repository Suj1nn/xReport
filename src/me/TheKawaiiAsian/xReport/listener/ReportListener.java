package me.TheKawaiiAsian.xReport.listener;

import me.TheKawaiiAsian.xReport.Core;
import me.TheKawaiiAsian.xReport.utils.UUIDManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

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
public class ReportListener implements Listener {

    @EventHandler
    public void onPlayerInteract(InventoryClickEvent event) {

        if (event.getWhoClicked() instanceof Player) {

            try {
                if (event.getClickedInventory().getName().contains("§b§lReporting §c")) {

                    String playerName = event.getClickedInventory().getName().replace("§b§lReporting §c", "");
                    UUID playerUUID = null;
                    Player reporter = (Player) event.getWhoClicked();
                    UUID reporterUUID = reporter.getUniqueId();
                    String reportType = event.getCurrentItem().getItemMeta().getDisplayName();

                    try {
                        playerUUID = UUIDManager.getUUIDOf(playerName);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    reporter.sendMessage("§2§l>> §aYou have successfully reported §r" + playerName);
                    reporter.closeInventory();
                    Core.getReportManager().reportPlayer(playerUUID, reportType, reporterUUID);

                }
            } catch (NullPointerException ignore) {
            }

        }

        //Core.getReportManager().reportPlayer(playerUUID, reportTypes, reporter.getUniqueId());
        //reporter.sendMessage("§2§l>> §aYou have successfully reported §r" + playerName);
        //reporter.closeInventory();

        //for (Player all : Bukkit.getOnlinePlayers()) {
        //    if (all.hasPermission("xreport.staff")) {
        //        all.sendMessage("§8§l[§c§lR§8§l]§r" + reporter.getDisplayName() + " §bhas reported §r" + playerName + " §bfor §7§n" + reportTypes);
        //    }
        //}


    }
}
