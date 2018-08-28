package de.gerolmed.msgbungee;

import de.gerolmed.msgbungee.utils.MessageUtils;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.HashMap;
import java.util.UUID;

public class MsgManager {

    /**
     * This HashMap stores the last sender of a receiver
     */
    private HashMap<UUID, UUID> respondList;

    public MsgManager() {
        respondList = new HashMap<>();
    }

    private ProxiedPlayer getLastPlayer(UUID receiver) {
        UUID sender = respondList.get(receiver);
        return sender == null ? null : ProxyServer.getInstance().getPlayer(sender);
    }

    public void sendMessage(ProxiedPlayer sender, ProxiedPlayer receiver, String message) {

        if(receiver == null) {
            MessageUtils.sendMessage(sender, "§cDieser Spieler ist im moment leider nicht online");
            return;
        }

        if(receiver == sender) {
            MessageUtils.sendMessage(sender, "§cDu kannst dir selbst keine Nachrichten senden");
            return;
        }

        message = "§a" + sender.getDisplayName() + " §7=> §a" + receiver.getDisplayName() + "§7: §e" + message;

        respondList.put(receiver.getUniqueId(), sender.getUniqueId());
        MessageUtils.sendMessage(receiver, message);
        MessageUtils.sendMessage(sender, message);
    }

    public void sendRespond(ProxiedPlayer sender, String message) {

        if(!respondList.containsKey(sender.getUniqueId())) {
            MessageUtils.sendMessage(sender, "§cBisher hast du keine Nachrichten erhalten");
            return;
        }

        ProxiedPlayer receiver = getLastPlayer(sender.getUniqueId());
        sendMessage(sender, receiver, message);
    }
}
