package de.fortushd.mittelalter.commands;

import de.fortushd.mittelalter.jobs.JobTypes;
import de.fortushd.mittelalter.jobs.JobsManager;
import de.fortushd.mittelalter.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JobQuitCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("job")) {
                if(args.length == 0) {

                    if(!JobsManager.getJob(p).equals("NONE")) {
                        JobsManager.setJobForPlayer(p, JobTypes.NONE);
                        p.sendMessage(Main.prefix + "§cDu hast gekündigt!");

                    } else {
                        p.sendMessage(Main.prefix + "§cDu hast keinen Job!");
                    }
                } else {
                    p.sendMessage(Main.prefix + "§cBenutze /quit um zu kündigen!");
                }
            } else {
                p.sendMessage(Main.prefix + "§cDu hast keine Berechtigung!");
            }
        } else {
            sender.sendMessage(Main.prefix + "§cDu musst ein Spieler sein um diesen Command zu beuntzen!");
        }

        return false;
    }
}
