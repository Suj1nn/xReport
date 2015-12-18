package me.TheKawaiiAsian.xReport;

import me.TheKawaiiAsian.xReport.commands.CommandManager;
import me.TheKawaiiAsian.xReport.commands.ReportCommand;
import me.TheKawaiiAsian.xReport.listener.ReportListener;
import me.TheKawaiiAsian.xReport.utils.ConfigFile;
import me.TheKawaiiAsian.xReport.utils.MySQL;
import me.TheKawaiiAsian.xReport.utils.NMSManager;
import me.TheKawaiiAsian.xReport.utils.ReportManager;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

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
public class Core extends JavaPlugin{

    private static Core instance;
    private static ReportManager reportManager;
    private static MySQL mySQL;
    private static NMSManager nmsManager;
    private static ArrayList<Player> reportingOther;

    public static Core getInstance() {
        return instance;
    }

    public static ReportManager getReportManager() {
        return reportManager;
    }

    public static MySQL getMySQL() {
        return mySQL;
    }

    public static NMSManager getNmsManager() {
        return nmsManager;
    }

    public static ArrayList<Player> getReportingOther() {
        return reportingOther;
    }

    public void onEnable() {
        instance = this;

        ConfigFile.reloadConfig();
        ConfigFile.getConfig().addDefault("Username", "username");
        ConfigFile.getConfig().addDefault("Password", "password");
        ConfigFile.getConfig().addDefault("Database", "database");
        ConfigFile.getConfig().addDefault("Port", "port");
        ConfigFile.getConfig().options().copyDefaults(true);
        ConfigFile.saveConfig();

        mySQL = new MySQL();
        mySQL.createTable();

        reportManager = new ReportManager();
        nmsManager = new NMSManager();
        reportingOther = new ArrayList<>();

        getCommand("report").setExecutor(new ReportCommand());
        getCommand("xreport").setExecutor(new CommandManager());
        getServer().getPluginManager().registerEvents(new ReportListener(), this);


    }

    public void onDisable() {
        getMySQL().close();

        instance = null;

    }

    //§dx§5Report


}
