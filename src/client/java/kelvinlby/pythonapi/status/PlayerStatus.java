package kelvinlby.pythonapi.status;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class PlayerStatus {
    /** Health Section **/
    public Float getHealth() {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null) {
            return player.getHealth();
        }
        return null;
    }

    public Float getMaxHealth() {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null) {
            return player.getMaxHealth();
        }
        return null;
    }

    public Float getHealthPercentage() {
        return getHealth() / getMaxHealth();
    }

    /** Hunger Section **/
    public Integer getHunger() {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null) {
            return player.getHungerManager().getFoodLevel();
        }
        return null;
    }

    public Boolean isNotFull() {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null) {
            return player.getHungerManager().isNotFull();
        }
        return null;
    }

    /** Inventory Section **/
    public Map<String, Integer> getInventory() {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null) {
            return null;
        }

        Map<String, Integer> offhand = new HashMap<>();
        ItemStack stack = player.getInventory().getStack(40); // Offhand slot

        if (!stack.isEmpty()) {
            Identifier itemId = Registries.ITEM.getId(stack.getItem());
            String itemName = itemId.toString();
            offhand.put(itemName, stack.getCount());
        }

        return offhand;
    }
}
