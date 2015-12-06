package me.TheKawaiiAsian.xReport.utils;

import me.TheKawaiiAsian.xReport.Core;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;

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
public class PlayerReportsFile {

    private UUID uuid;
    private FileConfiguration config = null;
    private File file = null;

    public PlayerReportsFile(String uuid) {
        this.uuid = UUID.fromString(uuid);
    }

    public void reload() {
        if (file == null) {
            file = new File(Core.getInstance().getDataFolder() + File.separator + "PlayerData", uuid + ".yml");
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration getConfig() {
        if (config == null) {
            reload();
        }
        return config;
    }

    public void save() {
        if (config == null || file == null) {
            return;
        }
        try {
            getConfig().save(file);
        } catch (IOException ex) {
            Bukkit.getLogger().log(Level.SEVERE, "Could not save config to " + file, ex);
        }
    }
}
