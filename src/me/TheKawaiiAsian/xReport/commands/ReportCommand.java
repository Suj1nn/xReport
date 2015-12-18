package me.TheKawaiiAsian.xReport.commands;

import me.TheKawaiiAsian.xReport.Core;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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

        if (!(sender instanceof Player)) {
            sender.sendMessage("§4§lPLAYER ONLY COMMAND!");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage("§4§l>> §cUsage: /report <Player>");
            return true;
        }

        Player target = Bukkit.getServer().getPlayer(args[0]);

        if (target == null) {
            player.sendMessage("§4§l>> §cCould not find player! Please check spelling.");
            return true;
        }

        player.openInventory(Core.getReportManager().reportInventory(target));
        player.sendMessage("§5§l>> §dReporting " + target.getName() + " §d...");

        return true;
    }
}
