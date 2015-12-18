package me.TheKawaiiAsian.xReport.commands.subcommands;

import me.TheKawaiiAsian.xReport.Core;
import me.TheKawaiiAsian.xReport.commands.xReportCommand;
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
public class LatestReportsCommand extends xReportCommand {

    public LatestReportsCommand() {
        super("LatestReports", "xreport.latest", new String[]{""});
    }

    @Override
    public void executor(CommandSender sender, String[] args) {

        if (!sender.hasPermission(this.getPermission())) {
            sender.sendMessage("§4§l>> §cPermission Denied. Please check your permissions.");
            return;
        }

        sender.sendMessage(Core.getReportManager().getLatestReports());
    }
}
