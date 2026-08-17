package me.fhoz.notenoughaddons.utils;

import dev.j3fftw.extrautils.utils.LoreBuilderDynamic;
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
        "&6Máquina económica para fabricar polvo mineral",
        "",
        "&7Una máquina económica todo en uno,",
        "&7Puedes utilizar directamente adoquín u otras variantes para obtener polvo mineral.",
        "",
        "&7&oMáquinas hechas para perros perezosos...",
        "",
        LoreBuilder.machine(MachineTier.GOOD, MachineType.MACHINE),
        LoreBuilder.speed(1),
        LoreBuilderDynamic.powerBuffer(BudgetDustFabricator.CAPACITY),
        LoreBuilderDynamic.powerPerSecond(BudgetDustFabricator.ENERGY_CONSUMPTION)
    );

    public static final SlimefunItemStack FLYING_BUBBLE = new SlimefunItemStack("FLYING_BUBBLE",
        Material.CRYING_OBSIDIAN,
        "&6burbujas voladoras",
        "",
        "&fpuede estar cerca45Obtenga la capacidad de volar en modo creativo dentro de la cuadrícula.",
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.powerPerSecond(128)
    );

    public static final SlimefunItemStack ANGEL_BLOCK = new SlimefunItemStack("ANGEL_BLOCK",
        Material.FEATHER,
        "&6cubo de angel",
        "",
        "&7Coloca un bloque debajo de tus pies.",
        "&7Muy útil cuando estás en el aire.",
        "",
        LoreBuilder.RIGHT_CLICK_TO_USE
    );


    public static final SlimefunItemStack MINER_BACKPACK = new SlimefunItemStack("MINER_BACKPACK",
        "8dcc6eb40f3bada41e4339888d6d207437598bdbd175c2e731191d5a9a42d3c8",
        "&6Mochila de minero",
        "",
        "&fPuede almacenar minerales",
        "&fDeposite automáticamente al recoger minerales.",
        "&fEfectivo cuando está en inventario",
        "",
        "&7tamaño: &e54 (caja grande)",
        "",
        "&7ID: <ID>",
        "",
        LoreBuilder.RIGHT_CLICK_TO_OPEN
    );

    // TERRARIA

    // TOOLS

    public static final SlimefunItemStack SHORTSWORD_COPPER = new SlimefunItemStack("SHORTSWORD_COPPER",
        Material.WOODEN_SWORD,
        "&fdaga de cobre",
        TerrariaUtils.getDMG(CopperShortsword.getDMG()),
        TerrariaUtils.getCC(CopperShortsword.getCC()),
        TerrariaUtils.useTimeConv(CopperShortsword.getUseTime()),
        TerrariaUtils.kbConv(CopperShortsword.getKB())
    );

    public static final SlimefunItemStack SHORTSWORD_TIN = new SlimefunItemStack("SHORTSWORD_TIN",
        Material.WOODEN_SWORD,
        "&fdaga de hojalata",
        TerrariaUtils.getDMG(TinShortsword.getDMG()),
        TerrariaUtils.getCC(TinShortsword.getCC()),
        TerrariaUtils.useTimeConv(TinShortsword.getUseTime()),
        TerrariaUtils.kbConv(TinShortsword.getKB())
    );

    public static final SlimefunItemStack SHORTSWORD_IRON = new SlimefunItemStack("SHORTSWORD_IRON",
        Material.WOODEN_SWORD,
        "&fdaga de hierro",
        TerrariaUtils.getDMG(IronShortsword.getDMG()),
        TerrariaUtils.getCC(IronShortsword.getCC()),
        TerrariaUtils.useTimeConv(IronShortsword.getUseTime()),
        TerrariaUtils.kbConv(IronShortsword.getKB())
    );

    public static final SlimefunItemStack SHORTSWORD_LEAD = new SlimefunItemStack("SHORTSWORD_LEAD",
        Material.WOODEN_SWORD,
        "&fdaga de plomo",
        TerrariaUtils.getDMG(LeadShortsword.getDMG()),
        TerrariaUtils.getCC(LeadShortsword.getCC()),
        TerrariaUtils.useTimeConv(LeadShortsword.getUseTime()),
        TerrariaUtils.kbConv(LeadShortsword.getKB())
    );

    public static final SlimefunItemStack SHORTSWORD_SILVER = new SlimefunItemStack("SHORTSWORD_SILVER",
        Material.WOODEN_SWORD,
        "&fdaga de plata",
        TerrariaUtils.getDMG(SilverShortsword.getDMG()),
        TerrariaUtils.getCC(SilverShortsword.getCC()),
        TerrariaUtils.useTimeConv(SilverShortsword.getUseTime()),
        TerrariaUtils.kbConv(SilverShortsword.getKB())
    );

    public static final SlimefunItemStack SHORTSWORD_TUNGSTEN = new SlimefunItemStack("SHORTSWORD_TUNGSTEN",
        Material.WOODEN_SWORD,
        "&fdaga de tungsteno",
        TerrariaUtils.getDMG(TungstenShortsword.getDMG()),
        TerrariaUtils.getCC(TungstenShortsword.getCC()),
        TerrariaUtils.useTimeConv(TungstenShortsword.getUseTime()),
        TerrariaUtils.kbConv(TungstenShortsword.getKB())
    );

    public static final SlimefunItemStack SHORTSWORD_GOLD = new SlimefunItemStack("SHORTSWORD_GOLD",
        Material.WOODEN_SWORD,
        "&fdaga dorada",
        TerrariaUtils.getDMG(GoldShortsword.getDMG()),
        TerrariaUtils.getCC(GoldShortsword.getCC()),
        TerrariaUtils.useTimeConv(GoldShortsword.getUseTime()),
        TerrariaUtils.kbConv(GoldShortsword.getKB())
    );

    public static final SlimefunItemStack SHORTSWORD_PLATINUM = new SlimefunItemStack("SHORTSWORD_PLATINUM",
        Material.WOODEN_SWORD,
        "&fdaga de platino",
        TerrariaUtils.getDMG(PlatinumShortsword.getDMG()),
        TerrariaUtils.getCC(PlatinumShortsword.getCC()),
        TerrariaUtils.useTimeConv(PlatinumShortsword.getUseTime()),
        TerrariaUtils.kbConv(PlatinumShortsword.getKB())
    );
}
