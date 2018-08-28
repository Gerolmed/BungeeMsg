package de.gerolmed.msgbungee.utils;

import net.md_5.bungee.api.connection.ProxiedPlayer;

public class MessageUtils {
    /**
     * Send a message to a player
     * @param proxiedPlayer
     * @param message
     */
    @SuppressWarnings("deprecation")
    public static void sendMessage(ProxiedPlayer proxiedPlayer, String message) {
        proxiedPlayer.sendMessage(message);
    }
}
