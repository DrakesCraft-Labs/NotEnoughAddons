package me.fhoz.notenoughaddons.utils;

import com.github.drakescraft_labs.slimefun4.api.items.SlimefunItemStack;
import com.github.drakescraft_labs.slimefun4.core.attributes.MachineTier;
import com.github.drakescraft_labs.slimefun4.core.attributes.MachineType;
import com.github.drakescraft_labs.slimefun4.utils.LoreBuilder;
import me.fhoz.notenoughaddons.machines.BudgetDustFabricator;
import me.fhoz.notenoughaddons.terraria.weapons.shortsword.CopperShortsword;
import me.fhoz.notenoughaddons.terraria.weapons.shortsword.GoldShortsword;
import me.fhoz.notenoughaddons.terraria.weapons.shortsword.IronShortsword;
import me.fhoz.notenoughaddons.terraria.weapons.shortsword.LeadShortsword;
import me.fhoz.notenoughaddons.terraria.weapons.shortsword.PlatinumShortsword;
import me.fhoz.notenoughaddons.terraria.weapons.shortsword.SilverShortsword;
import me.fhoz.notenoughaddons.terraria.weapons.shortsword.TinShortsword;
import me.fhoz.notenoughaddons.terraria.weapons.shortsword.TungstenShortsword;
import org.bukkit.Material;

/**
 * Specifies all plugin items
 */
public class NEAItems {

    private NEAItems() {
    }

    // Machines
    public static final SlimefunItemStack BUDGET_DUST_FABRICATOR = new SlimefunItemStack("BUDGET_DUST_FABRICATOR",
        Material.CRACKED_STONE_BRICKS,
        "&6Budget Dust Fabricator",
        "",
        "&7An all-in-one and cheap machine,",
        "&7extracts dust directly from cobblestone or its variants",
        "",
        "&7&oA machine for the lazy...",
        "",
        LoreBuilder.machine(MachineTier.GOOD, MachineType.MACHINE),
        LoreBuilder.speed(1),
        LoreBuilder.powerBuffer(BudgetDustFabricator.CAPACITY),
        LoreBuilder.powerPerSecond(BudgetDustFabricator.ENERGY_CONSUMPTION)
    );

    public static final SlimefunItemStack FLYING_BUBBLE = new SlimefunItemStack("FLYING_BUBBLE",
        Material.CRYING_OBSIDIAN,
        "&6Flying Bubble",
        "",
        "&fAllows creative flight within a 45 block radius",
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.powerPerSecond(128)
    );

    public static final SlimefunItemStack ANGEL_BLOCK = new SlimefunItemStack("ANGEL_BLOCK",
        Material.FEATHER,
        "&6Angel Block",
        "",
        "&7Places a block beneath your feet",
        "&7Very useful while in mid-air",
        "",
        LoreBuilder.RIGHT_CLICK_TO_USE
    );

    public static final SlimefunItemStack MINER_BACKPACK = new SlimefunItemStack("MINER_BACKPACK",
        "8dcc6eb40f3bada41e4339888d6d207437598bdbd175c2e731191d5a9a42d3c8",
        "&6Miner's Backpack",
        "",
        "&fStores ores",
        "&fAutomatically collects them on pickup",
        "&fJust keep it in your inventory",
        "",
        "&7Size: &e54 (Double Chest)",
        "",
        "&7ID: <ID>",
        "",
        LoreBuilder.RIGHT_CLICK_TO_OPEN
    );

    // TERRARIA

    // TOOLS

    public static final SlimefunItemStack SHORTSWORD_COPPER = new SlimefunItemStack("SHORTSWORD_COPPER",
        Material.WOODEN_SWORD,
        "&fCopper Shortsword",
        TerrariaUtils.getDMG(CopperShortsword.getDMG()),
        TerrariaUtils.getCC(CopperShortsword.getCC()),
        TerrariaUtils.useTimeConv(CopperShortsword.getUseTime()),
        TerrariaUtils.kbConv(CopperShortsword.getKB())
    );

    public static final SlimefunItemStack SHORTSWORD_TIN = new SlimefunItemStack("SHORTSWORD_TIN",
        Material.WOODEN_SWORD,
        "&fTin Shortsword",
        TerrariaUtils.getDMG(TinShortsword.getDMG()),
        TerrariaUtils.getCC(TinShortsword.getCC()),
        TerrariaUtils.useTimeConv(TinShortsword.getUseTime()),
        TerrariaUtils.kbConv(TinShortsword.getKB())
    );

    public static final SlimefunItemStack SHORTSWORD_IRON = new SlimefunItemStack("SHORTSWORD_IRON",
        Material.WOODEN_SWORD,
        "&fIron Shortsword",
        TerrariaUtils.getDMG(IronShortsword.getDMG()),
        TerrariaUtils.getCC(IronShortsword.getCC()),
        TerrariaUtils.useTimeConv(IronShortsword.getUseTime()),
        TerrariaUtils.kbConv(IronShortsword.getKB())
    );

    public static final SlimefunItemStack SHORTSWORD_LEAD = new SlimefunItemStack("SHORTSWORD_LEAD",
        Material.WOODEN_SWORD,
        "&fLead Shortsword",
        TerrariaUtils.getDMG(LeadShortsword.getDMG()),
        TerrariaUtils.getCC(LeadShortsword.getCC()),
        TerrariaUtils.useTimeConv(LeadShortsword.getUseTime()),
        TerrariaUtils.kbConv(LeadShortsword.getKB())
    );

    public static final SlimefunItemStack SHORTSWORD_SILVER = new SlimefunItemStack("SHORTSWORD_SILVER",
        Material.WOODEN_SWORD,
        "&fSilver Shortsword",
        TerrariaUtils.getDMG(SilverShortsword.getDMG()),
        TerrariaUtils.getCC(SilverShortsword.getCC()),
        TerrariaUtils.useTimeConv(SilverShortsword.getUseTime()),
        TerrariaUtils.kbConv(SilverShortsword.getKB())
    );

    public static final SlimefunItemStack SHORTSWORD_TUNGSTEN = new SlimefunItemStack("SHORTSWORD_TUNGSTEN",
        Material.WOODEN_SWORD,
        "&fTungsten Shortsword",
        TerrariaUtils.getDMG(TungstenShortsword.getDMG()),
        TerrariaUtils.getCC(TungstenShortsword.getCC()),
        TerrariaUtils.useTimeConv(TungstenShortsword.getUseTime()),
        TerrariaUtils.kbConv(TungstenShortsword.getKB())
    );

    public static final SlimefunItemStack SHORTSWORD_GOLD = new SlimefunItemStack("SHORTSWORD_GOLD",
        Material.WOODEN_SWORD,
        "&fGold Shortsword",
        TerrariaUtils.getDMG(GoldShortsword.getDMG()),
        TerrariaUtils.getCC(GoldShortsword.getCC()),
        TerrariaUtils.useTimeConv(GoldShortsword.getUseTime()),
        TerrariaUtils.kbConv(GoldShortsword.getKB())
    );

    public static final SlimefunItemStack SHORTSWORD_PLATINUM = new SlimefunItemStack("SHORTSWORD_PLATINUM",
        Material.WOODEN_SWORD,
        "&fPlatinum Shortsword",
        TerrariaUtils.getDMG(PlatinumShortsword.getDMG()),
        TerrariaUtils.getCC(PlatinumShortsword.getCC()),
        TerrariaUtils.useTimeConv(PlatinumShortsword.getUseTime()),
        TerrariaUtils.kbConv(PlatinumShortsword.getKB())
    );
}
