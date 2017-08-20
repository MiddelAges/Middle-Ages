package de.fortushd.mittelalter.commands;

import de.fortushd.mittelalter.jobs.JobTypes;
import de.fortushd.mittelalter.jobs.JobsManager;
import de.fortushd.mittelalter.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JobsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player) {
            Player p = (Player)sender;
            if(p.hasPermission("job")) {
                if(args.length == 1) {

                    if(!JobsManager.getJob(p).equals("NONE")) {

                        if(args[0].equalsIgnoreCase("builder")) {
                            JobsManager.setJobForPlayer(p, JobTypes.BUILDER);
                            p.sendMessage(Main.prefix + "§2Du hast den Job §eBuilder §2gewählt!");
                        } else if(args[0].equalsIgnoreCase("farmer")) {
                            JobsManager.setJobForPlayer(p, JobTypes.FARMER);
                            p.sendMessage(Main.prefix + "§2Du hast den Job §eFarmer §2gewählt!");
                        } else if(args[0].equalsIgnoreCase("hunter")) {
                            JobsManager.setJobForPlayer(p, JobTypes.HUNTER);
                            p.sendMessage(Main.prefix + "§2Du hast den Job §eHunter §2gewählt!");
                        } else if(args[0].equalsIgnoreCase("lumberjack")) {
                            JobsManager.setJobForPlayer(p, JobTypes.LUMBERJACK);
                            p.sendMessage(Main.prefix + "§2Du hast den Job §eLumberjack §2gewählt!");
                        } else if(args[0].equalsIgnoreCase("miner")) {
                            JobsManager.setJobForPlayer(p, JobTypes.MINER);
                            p.sendMessage(Main.prefix + "§2Du hast den Job §eMiner §2gewählt!");
                        } else {
                            p.sendMessage(Main.prefix + "§cFolgende Jobs sind verfügbar: " +
                                    "§eBuilder, Farmer, Hunter, Lumberjack, Miner");
                        }


                    } else {
                        p.sendMessage(Main.prefix + "§cDu hast bereits einen Job!");
                    }

                } else {
                    p.sendMessage(Main.prefix + "§cBenutze /job <Job> um einen Job zu wählen!");
                }
            } else {
                p.sendMessage( Main.prefix + "§cDu hast keine Berechtigung für diesen Befehl!");
            }
        } else {
            sender.sendMessage(Main.prefix + "§cDu musst ein Spieler sein um diesen Befehl zu benutzen!");
        }

        return false;
    }
}
