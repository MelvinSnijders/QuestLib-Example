package nl.themelvin.questlibexample.quest;

import nl.themelvin.questlib.abstracts.Quest;
import nl.themelvin.questlib.example.CobblestoneObjective;
import nl.themelvin.questlib.reward.types.ItemReward;
import nl.themelvin.questlib.reward.types.MultiReward;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BreakQuest extends Quest {

    // Empty constructor is required.
    public BreakQuest() {

        // Name and description aren't neccessary and are not used by QuestLib.
        // You might want to use it in your own plugin.
        this.setName("Break Quest");
        this.setDescription("Break different kind of blocks");

        // Set the messages sent when the quest is started and/or completed.
        this.setStartMessage("&bQuest started: " + this.getName());
        this.setCompleteMessage("&bQuest finished: " + this.getName());

        // You can create custom rewards for quests.
        ItemReward reward1 = new ItemReward(new ItemStack(Material.EMERALD, 2));
        ItemReward reward2 = new ItemReward(new ItemStack(Material.IRON_INGOT, 10));

        // A multireward combines different kinds of rewards to one reward object.
        MultiReward reward = new MultiReward(reward1, reward2);

        // The reward will be given when a player finished the quest.
        this.setReward(reward);

        // This is important, every objective should be registered in the quest object.
        // Insertion order will be maintained, so in this case the player has to finish the cobblestone objective before moving on to the dirt objective.
        this.addObjective(new CobblestoneObjective());

    }

}
