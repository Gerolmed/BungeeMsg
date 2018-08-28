package de.gerolmed.msgbungee;

import de.gerolmed.msgbungee.commands.MsgCommand;
import de.gerolmed.msgbungee.commands.RespondCommand;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {

    private MsgManager msgManager;

    @Override
    public void onLoad() {
        msgManager = new MsgManager();
    }

    @Override
    public void onEnable() {
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new RespondCommand(this));
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new MsgCommand(this));
    }

    public MsgManager getMsgManager() {
        return msgManager;
    }
}
