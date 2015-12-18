package me.TheKawaiiAsian.xReport.utils;

import net.md_5.bungee.api.chat.*;

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
public class NMSManager {

    public TextComponent runCommand(String ChatMSG, String ClickMSG, String HoverMsg) {
        TextComponent message = new TextComponent(ChatMSG);
        message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ClickMSG));
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(HoverMsg).create()));

        return message;
    }

    public TextComponent suggestCommand(String ChatMSG, String ClickMSG, String HoverMsg) {
        TextComponent message = new TextComponent(ChatMSG);
        message.setClickEvent( new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, ClickMSG));
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(HoverMsg).create()));

        return message;
    }
}
