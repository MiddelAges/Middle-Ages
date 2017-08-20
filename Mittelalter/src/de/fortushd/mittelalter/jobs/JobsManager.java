package de.fortushd.mittelalter.jobs;

import de.fortushd.mittelalter.jobs.JobTypes;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class JobsManager {

    public static void setJobForPlayer(Player p, JobTypes type) {

        File folder = new File("plugins/Mittelalter/Players");
        File file = new File("plugins/Mittelalter/Players", p.getUniqueId().toString() + ".yml");

        if(!folder.exists()) {
            folder.mkdir();
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        cfg.set("Job", String.valueOf(type));

    }

    public static String getJob(Player p) {

        File file = new File("plugins/Mittelalter/Players", p.getUniqueId().toString() + ".yml");
        if(file.exists()) {
            YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
            return cfg.getString("Job");
        } else {
            return null;
        }
    }

    public static boolean existJob(Player p) {

        File file = new File("plugins/Mittelalter/Players", p.getUniqueId().toString() + ".yml");
        if(file.exists()) {
            YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
            if(cfg.contains("Job")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }
}
