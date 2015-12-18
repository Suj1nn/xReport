package me.TheKawaiiAsian.xReport.commands;

import me.TheKawaiiAsian.xReport.commands.subcommands.HelpCommand;
import me.TheKawaiiAsian.xReport.commands.subcommands.InfoCommand;
import me.TheKawaiiAsian.xReport.commands.subcommands.LatestReportsCommand;
import me.TheKawaiiAsian.xReport.commands.subcommands.SearchByIDCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

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
public class CommandManager implements CommandExecutor {

    private static List<xReportCommand> commandList = new ArrayList<>();

    public xReportCommand getCommand(String label) {

        for (xReportCommand xReportCommand : commandList) {
            if (xReportCommand.getLabel().equalsIgnoreCase(label)) {
                return xReportCommand;
            }
        }
        return null;
    }

    public static List<xReportCommand> getCommandList() {
        return commandList;
    }

    public CommandManager() {

        commandList = new ArrayList<>();

        commandList.add(new InfoCommand());
        commandList.add(new HelpCommand());
        commandList.add(new LatestReportsCommand());
        commandList.add(new SearchByIDCommand());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("xreport")) {

            if (args.length < 1) {
                //TODO: ACTIVATE XPERMS HELP COMMAND
                if (!sender.hasPermission("xreport.staff")) {
                    getCommand("Info").executor(sender, args);
                    return true;
                } else {
                    getCommand("Help").executor(sender, args);
                }
                return true;
            }

            String commandLabel = args[0];
            xReportCommand xReportCommand = getCommand(commandLabel);

            if (getCommand(commandLabel) == null) {
                //TODO: ACTIVATE XPERMS HELP COMMAND
                if (!sender.hasPermission("xreport.staff")) {
                    getCommand("Info").executor(sender, args);
                    return true;
                } else {
                    getCommand("Help").executor(sender, args);
                }
                return true;
            }

            xReportCommand.executor(sender, args);
            return true;
        }

        return true;
    }
}
