package me.TheKawaiiAsian.xReport.listener;

import me.TheKawaiiAsian.xReport.Core;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

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

                    Player player = Bukkit.getPlayer(event.getInventory().getName().replace("§b§lReporting §c", ""));

                    if (player == null) {
                        ((Player) event.getWhoClicked()).getPlayer().sendMessage("§4§l>> §cCould not find player! Please check spelling.");
                        ((Player) event.getWhoClicked()).getPlayer().closeInventory();
                        return;
                    }

                    Core.getReportManager().reportPlayer(player, ((Player) event.getWhoClicked()).getPlayer(), event.getCurrentItem().getItemMeta().getDisplayName());
                    ((Player) event.getWhoClicked()).getPlayer().sendMessage("§2§l>> §aYou have reported §r" + player.getName() + " §afor §r" + event.getCurrentItem().getItemMeta().getDisplayName());
                    ((Player) event.getWhoClicked()).getPlayer().closeInventory();

                    for (Player all : Bukkit.getOnlinePlayers()) {
                       if (all.hasPermission("xreport.staff")) {
                           all.sendMessage("§8§l[§c§lR§8§l]§r" + ((Player) event.getWhoClicked()).getPlayer().getDisplayName() + " §bhas reported §r" + player.getName() + " §bfor §7§n" + event.getCurrentItem().getItemMeta().getDisplayName());
                        }
                    }

                }
            } catch (NullPointerException ignore) {
            }

        }
    }
}
