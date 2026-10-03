package me.fhoz.notenoughaddons.items.electric;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.ItemHandler;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import me.fhoz.notenoughaddons.abstractitems.AMachine;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;


public class FlyingBubble extends AMachine {
    private static final Map<Location, Set<UUID>> allEnabledPlayers = new HashMap<>();
    private static final Set<UUID> allUuids = new HashSet<>();
    private static final int[] BORDER = new int[] {1, 2, 6, 7, 9, 10, 11, 15, 16, 17, 19, 20, 24, 25};
    private static final int[] BORDER_IN = new int[] {3, 4, 5, 12, 14, 21, 22, 23};
    private static final int[] BORDER_OUT = new int[] {0, 8, 18, 26};

    public FlyingBubble(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        addItemHandler(onBlockBreak());
    }

    @Override
    public void preRegister() {
        addItemHandler(new BlockTicker() {

            @Override
            public void tick(Block b, SlimefunItem sfItem, Config data) {
                FlyingBubble.this.tick(b);
            }

            @Override
            public boolean isSynchronized() {
                return true;
            }
        });
    }

    @Override
    public void tick(Block b) {
        Set<UUID> playersInBubble = allEnabledPlayers.getOrDefault(b.getLocation(), new HashSet<>());
        Collection<Entity> bubbledEntities = b.getWorld().getNearbyEntities(b.getLocation(), 25, 25, 25);
        for (Entity entity : bubbledEntities) {
            if (entity instanceof Player && getCharge(b.getLocation()) >= getEnergyConsumption()) {
                Player p = (Player) entity;
                playersInBubble.add(p.getUniqueId());
                allEnabledPlayers.put(b.getLocation(), playersInBubble);
                if (!p.getAllowFlight()) {
                    p.setAllowFlight(true);
                    removeCharge(b.getLocation(), getEnergyConsumption());
                }
            }
        }

        // Remove through the iterator: playersInBubble is the same Set stored in allEnabledPlayers,
        // so removing via the map while iterating throws ConcurrentModificationException.
        List<UUID> leftBubble = new ArrayList<>();
        Iterator<UUID> iterator = playersInBubble.iterator();
        while (iterator.hasNext()) {
            UUID uuid = iterator.next();
            Player p = Bukkit.getPlayer(uuid);
            if (p == null) {
                iterator.remove();
            } else if (!bubbledEntities.contains(p)) {
                iterator.remove();
                leftBubble.add(uuid);
            }
        }

        for (UUID uuid : leftBubble) {
            checkPlayer(uuid);
        }
    }

    private void checkPlayer(UUID u) {
        allUuids.clear();
        for (Map.Entry<Location, Set<UUID>> entry : allEnabledPlayers.entrySet()) {
            Set<UUID> uuidSet = entry.getValue();
            for (UUID uuid : uuidSet) {
                allUuids.add(uuid);
            }
        }

        if (!allUuids.contains(u)) {
            Player p = Bukkit.getPlayer(u);
            if (p == null) {
                return;
            }
            p.setAllowFlight(false);
            p.setFlying(false);
            p.setFallDistance(0.0f);
        }
    }

    private ItemHandler onBlockBreak() {
        return new BlockBreakHandler(false, false) {

            @Override
            public void onPlayerBreak(BlockBreakEvent e, ItemStack tool, List<ItemStack> drops) {
                Set<UUID> bubblePlayers = allEnabledPlayers.remove(e.getBlock().getLocation());
                if (bubblePlayers != null) {
                    for (UUID uuid : bubblePlayers) {
                        checkPlayer(uuid);
                    }
                }
            }
        };
    }

    @Override
    public boolean isGraphical() {
        return false;
    }

    @Override
    public String getMachineIdentifier() {
        return "FLYING_BUBBLE";
    }

    @Override
    public List<int[]> getBorders() {
        List<int[]> borders = new ArrayList<>();
        borders.add(BORDER);
        borders.add(BORDER_IN);
        borders.add(BORDER_OUT);

        return borders;
    }

    @Override
    public int[] getInputSlots() {
        return new int[] {13};
    }

    @Override
    public int[] getOutputSlots() {
        return new int[] {13};
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.DRAGON_EGG);
    }

    @Override
    public int getProgressBarSlot() {
        return 4;
    }

}