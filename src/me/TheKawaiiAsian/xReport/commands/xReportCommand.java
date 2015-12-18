package me.TheKawaiiAsian.xReport.commands;

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
public abstract class xReportCommand {

    private String Label, Permission;
    private String[] args;

    public xReportCommand(String label, String permission, String[] args) {
        Label = label;
        Permission = permission;
        this.args = args;
    }

    public String getLabel() {
        return Label;
    }

    public String getPermission() {
        return Permission;
    }

    public String[] getArgs() {
        return args;
    }

    public abstract void executor(CommandSender sender, String[] args);
}
