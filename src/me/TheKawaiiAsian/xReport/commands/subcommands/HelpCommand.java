package me.TheKawaiiAsian.xReport.commands.subcommands;

import me.TheKawaiiAsian.xReport.Core;
import me.TheKawaiiAsian.xReport.commands.CommandManager;
import me.TheKawaiiAsian.xReport.commands.xReportCommand;
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
public class HelpCommand extends xReportCommand {

    public HelpCommand() {
        super("Help", "", new String[]{""});
    }

    @Override
    public void executor(CommandSender sender, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("§6§l>> §dx§5Report §eHelp");
            return;
        }


        Player player = (Player) sender;
        player.sendMessage("§6§l>> §dx§5Report §eHelp");
        player.spigot().sendMessage(Core.getNmsManager().runCommand("§6§l> §e§l* §5Help", "/xReport Help", "§e§lUSAGE\n\n§3Usage: §7/xReport Help\n§bDescription: §7Shows the help menu \n§3Permission: §7EVERYONE"),
                Core.getNmsManager().runCommand("  §6§l* §5Info", "/xReport Info", "§e§lUSAGE\n\n§3Usage: §7/xReport Info\n§bDescription: §7Shows Information about this plugin \n§3Permission: §7EVERYONE"));

        player.spigot().sendMessage(Core.getNmsManager().runCommand("§6§l> §e§l* §5Latest Reports", "/xReport LatestReports", "§e§lUSAGE\n\n§3Usage: §7/xReport LatestReports\n§bDescription: §7Shows the last 10 reports \n§3Permission: §7" + new LatestReportsCommand().getPermission()),
                Core.getNmsManager().suggestCommand("  §6§l* §5Search ID", "/xReport SearchID <ID>", "§e§lUSAGE\n\n§3Usage: §7/xReport SearchID <ID> \n§bDescription: §7Shows Information a specific report \n§3Permission: §7" + new SearchByIDCommand().getPermission()));

    }
}
