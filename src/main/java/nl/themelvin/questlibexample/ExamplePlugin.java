package nl.themelvin.questlibexample;

import nl.themelvin.questlib.QuestLib;
import nl.themelvin.questlib.storage.types.YAML;
import nl.themelvin.questlibexample.quest.BreakQuest;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class ExamplePlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        QuestLib questLib = QuestLib.getInstance();

        // QuestLib offers default MySQL and YAML storage.
        // Any storage method can be added, if you extend the QuestStorage class.
        File storageLocation = new File(this.getDataFolder() + "/data", "data.yml");
        YAML questStorage = new YAML(storageLocation);

        // Register quests BEFORE you init QuestLib.
        questLib.registerQuest("breakQuest", BreakQuest.class);

        // IMPORTANT: Initiate the library, otherwise it will not work.
        questLib.init(this, questStorage);

    }

    @Override
    public void onDisable() {

        QuestLib questLib = QuestLib.getInstance();

        // IMPORTANT: Disable the library, otherwise data will not be saved.
        questLib.disable();

    }

}
