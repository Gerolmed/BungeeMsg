package de.gerolmed.msgbungee.commands;

import de.gerolmed.msgbungee.Main;
import de.gerolmed.msgbungee.utils.MessageUtils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class RespondCommand extends Command {

    private Main plugin;

    public RespondCommand(Main plugin) {
        super("r", "bungee.respond", "respond");
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
        if(args.length == 0) {
            MessageUtils.sendMessage(proxiedPlayer, "§c/r <Nachricht>");
            return;
        }

        String message = "";

        for(int i = 0; i < args.length; i++)
        {
            message = message + args[i] + " ";
        }

        plugin.getMsgManager().sendRespond(proxiedPlayer, message);

    }
}
