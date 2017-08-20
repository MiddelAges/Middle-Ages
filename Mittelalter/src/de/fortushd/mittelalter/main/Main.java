package de.fortushd.mittelalter.main;

import de.fortushd.mittelalter.commands.JobQuitCommand;
import de.fortushd.mittelalter.commands.JobsCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static String prefix = "§8[§cMittelalter§8]";

    public void onEnable() {
        System.out.println("Mittelalter wurde geladen");

        registerCommands();
    }

    public void onDisable() {
        System.out.println("Mittelalter wurde beendet");
    }

    private void registerCommands() {

        getCommand("job").setExecutor(new JobsCommand());
        getCommand("quit").setExecutor(new JobQuitCommand());
    }
}
