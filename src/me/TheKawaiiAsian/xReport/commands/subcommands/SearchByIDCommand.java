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
public class SearchByIDCommand extends xReportCommand {

    public SearchByIDCommand() {
        super("SearchID", "xreport.search.id", new String[]{"<ID>"});
    }

    @Override
    public void executor(CommandSender sender, String[] args) {

        if (!sender.hasPermission(this.getPermission())) {
            sender.sendMessage("§4§l>> §cPermission Denied. Please check your permissions.");
            return;
        }

        if (args.length <= this.getArgs().length) {
            sender.sendMessage("§4§l>> §cUsage: /xReport SearchID <ID>");
            return;
        }

        try {
            Integer id = Integer.parseInt(args[1]);

            sender.sendMessage(Core.getReportManager().getReport(id));

        }catch (NumberFormatException e) {
            sender.sendMessage("§4§l>> §cThis in an invalid number.");
        }
    }
}
