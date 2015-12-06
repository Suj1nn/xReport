package me.TheKawaiiAsian.xReport.utils;

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
public enum ReportTypes {

    XRAY("X-Ray"),
    KILLAURA("Kill-Aura"),
    ANTIKNOCKBACK("Anti-Knockback"),
    NOFALL("No-Fall"),
    SPEED("Speed"),
    FLY("Fly"),
    SPIDER("Spider/Climb"),
    AUTOSOUP("Auto-Soup"),
    AUTOARMOR("Auto-Armour"),
    AIMBOT("Aimbot"),
    OTHER("Other");



    private String name;

    ReportTypes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
