package nl.themelvin.questlibexample.quest.objectives;

import nl.themelvin.questlib.abstracts.QuestObjective;
import nl.themelvin.questlib.reward.types.ItemReward;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class CobblestoneObjective extends QuestObjective {

    // In objectives, a empty constructor is NOT required since you have to instantiate the object yourself in the quest.
    public CobblestoneObjective() {

        // Name and description aren't neccessary and are not used by QuestLib.
        // You might want to use it in your own plugin.
        this.setName("Cobblestone objective");
        this.setDescription("Break 5 cobblestone blocks.");

        // The optional reward will be given when a player finishes this objective
        ItemReward reward = new ItemReward(new ItemStack(Material.DIAMOND, 1), "&6You received &e1x Diamond &6as a reward.");
        this.setReward(reward);

        // Set the messages sent when the objective is started and/or completed.
        this.setStartMessage("&b" + this.getName() + ": " + this.getDescription());
        this.setCompleteMessage("&aYou finished this objective.");

    }


    // You can add as much events as you want, they will be automatically registered and unregistered by QuestLib.
    @EventHandler
    public void blockBreak(BlockBreakEvent event) {

        // This is VERY important for every event, QuestLib can't detect what event belongs to what player.
        // Using this, the event will not be called for other players except the one in this objective.
        if(!this.isFrom(event.getPlayer())) return;

        // Example only, check if material is cobblestone
        if(event.getBlock().getType() != Material.COBBLESTONE) {
            return;
        }

        // Increment the data by 1.
        this.incrementData("count", 1);

        // Check If the data is more than 5
        if(this.getDataInt("count") >= 5) {

            // Complete the objective, optional rewards will be given and messages will be sent.
            this.complete();

        }

    }

}
