package tacohime.tacotime;

import java.text.SimpleDateFormat;
import java.util.Date;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

public class TacoTime extends Plugin
{
    @Override
    public void onEnable()
    {
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Command("tacotime")
        {
            public void execute(CommandSender sender, String[] args)
            {
                Date now = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
                SimpleDateFormat sdf2 = new SimpleDateFormat("MMM dd, yyyy");
                
                if (sender instanceof ProxiedPlayer)
                {
                    ProxiedPlayer p = (ProxiedPlayer)sender;
                    p.sendMessage(ChatColor.GREEN + "Taco" + ChatColor.AQUA + "Time" + ChatColor.WHITE + ": " + ChatColor.YELLOW + sdf.format(now) + ChatColor.WHITE + " | " + ChatColor.GOLD + sdf2.format(now));
                }
                else 
                    ProxyServer.getInstance().getLogger().info("Time: " + sdf.format(now) + " | " + sdf2.format(now));
            }
        });
    }

    @Override
    public void onDisable()
    {
    }
}
