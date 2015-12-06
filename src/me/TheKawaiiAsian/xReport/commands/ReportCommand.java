package me.TheKawaiiAsian.xReport.commands;

import me.TheKawaiiAsian.xReport.Core;
import me.TheKawaiiAsian.xReport.utils.UUIDManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
public class ReportCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {

        // /report <Player> v

        if (!(sender instanceof Player)) {
            sender.sendMessage("§4§lPLAYER ONLY COMMAND!");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage("§4§l>> §cUsage: /report <Player>");
            return true;
        }

        UUID uuid = null;

        try {
            uuid = UUIDManager.getUUIDOf(args[0]);
            player.sendMessage("§5§l>> §dReporting §r" + args[0] + " §d..." );
        } catch (Exception e) {
            sender.sendMessage("§4§l>> §cPlayer not found! Please check spelling.");
        }

        try {
            player.openInventory(Core.getReportManager().reportInventory(uuid));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
}
