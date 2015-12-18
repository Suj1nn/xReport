package me.TheKawaiiAsian.xReport.commands.subcommands;

import me.TheKawaiiAsian.xReport.Core;
import me.TheKawaiiAsian.xReport.commands.xReportCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

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
public class InfoCommand extends xReportCommand {

    public InfoCommand() {
        super("Info", "", new String[]{""});
    }

    @Override
    public void executor(CommandSender sender, String[] args) {

        sender.sendMessage(ChatColor.STRIKETHROUGH + "§7============ " + "§dx§5Report" + " §7============");
        sender.sendMessage("");
        sender.sendMessage("§6§l>> §3" + "Version: §7" + Core.getInstance().getDescription().getVersion());
        sender.sendMessage("§6§l>> §3" + "Developers: §7" + "TheKawaiiAsian");
        sender.sendMessage("§6§l>> §3" + "Description: §7" + Core.getInstance().getDescription().getDescription());
        sender.sendMessage("");
        sender.sendMessage(ChatColor.STRIKETHROUGH + "§7============ " + "§dx§5Report" + " §7============");

    }
}
