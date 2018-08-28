package de.gerolmed.msgbungee.commands;

import de.gerolmed.msgbungee.Main;
import de.gerolmed.msgbungee.utils.MessageUtils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class MsgCommand extends Command {

    private Main plugin;

    public MsgCommand(Main plugin) {
        super("msg", "bungee.msg", "tell");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {


        /**
         * Jump off as non player access
         */
        if(!(sender instanceof ProxiedPlayer))
        {
            sender.sendMessage(new TextComponent("You need to be a player to execute this command!"));
            return;
        }

        ProxiedPlayer proxiedPlayer = (ProxiedPlayer) sender;

        /**
         * Send help
         */
        if(args.length == 0 ||args.length == 1) {
            MessageUtils.sendMessage(proxiedPlayer, "§c/msg <Name> <Nachricht>");
            return;
        }

        String targetName = args[0];
        String message = "";
        ProxiedPlayer target = ProxyServer.getInstance().getPlayer(targetName);

        for(int i = 1; i < args.length; i++)
        {
            message = message + args[i];
        }

        plugin.getMsgManager().sendMessage(proxiedPlayer, target, message);

    }
}
