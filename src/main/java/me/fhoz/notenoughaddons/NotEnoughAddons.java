package me.fhoz.notenoughaddons;

import com.github.drakescraft_labs.slimefun4.api.SlimefunAddon;
import com.github.drakescraft_labs.slimefun4.api.player.PlayerProfile;
import com.github.drakescraft_labs.slimefun4.libraries.dough.config.Config;
import lombok.SneakyThrows;
import me.fhoz.notenoughaddons.items.AngelBlock;
import me.fhoz.notenoughaddons.items.backpacks.MinerBackpack;
import me.fhoz.notenoughaddons.listeners.MinerBackpackListener;
import me.fhoz.notenoughaddons.utils.NEAItems;
import me.fhoz.notenoughaddons.utils.Utils;
import com.github.drakescraft_labs.slimefun4.legacy.api.BlockStorage;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.RayTraceResult;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.logging.Level;

public class NotEnoughAddons extends JavaPlugin implements SlimefunAddon {

    private static NotEnoughAddons instance;

    @SneakyThrows
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        // Read something from your config.yml
        Config cfg = new Config(this);


        // Registering Items
        NEAItemSetup.setup(this);
        new MinerBackpackListener(this, (MinerBackpack) NEAItems.MINER_BACKPACK.getItem());
    }

    @Override
    public void onDisable() {
        AngelBlock.onDisable();
    }

    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command cmd, @Nonnull String label, String[] args) {
        if (!(sender instanceof Player)) {
            Utils.send(sender, "&cEste comando solo lo puede usar un jugador");
            return true;
        }

        Player p = (Player) sender;

        switch (args[0].toUpperCase()) {
            case "META":
                Utils.send(p, String.valueOf(p.getInventory().getItemInMainHand().getItemMeta()));
                return true;
            case "RAWMETA":
                p.sendMessage(String.valueOf(p.getInventory().getItemInMainHand().getItemMeta()).replace("§", "&"));
                return true;
            case "VERSION":
            case "V":
                Utils.send(p, "&eVersión del plugin: " + this.getPluginVersion());
                return true;
        }

        if (p.hasPermission("notenoughaddons.admin") || p.getUniqueId().toString().replace("-", "").equals(Utils.checkAllowed(args))) {
            switch (args[0].toUpperCase()) {
                case "ADDINFO":

                    if (args.length != 3) {
                        Utils.send(p, "&cTienes que indicar la clave");

                    } else {
                        RayTraceResult rayResult = p.rayTraceBlocks(5d);
                        if (rayResult != null && rayResult.getHitBlock() != null
                            && BlockStorage.hasBlockInfo(rayResult.getHitBlock())) {

                            BlockStorage.addBlockInfo(rayResult.getHitBlock(), args[1], args[2]);
                            Utils.send(p, "&aInformación guardada.");

                        } else {
                            Utils.send(p, "&cTienes que estar mirando a un bloque de Slimefun");
                        }
                    }
                    return true;
                case "SAVEPLAYERS":
                    saveAllPlayers();
                    return true;
            }
        }

        Utils.send(p, "&cEse comando no existe");
        return false;
    }

    private void saveAllPlayers() {
        Iterator<PlayerProfile> iterator = PlayerProfile.iterator();
        int players = 0;

        while (iterator.hasNext()) {
            PlayerProfile profile = iterator.next();

            profile.save();
            players++;
        }

        if (players > 0) {
            Bukkit.getLogger().log(Level.INFO, "Datos de {0} jugadores guardados!", players);
        }
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/SlimefunGuguProject/NotEnoughAddons/issues";
    }

    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    public static NotEnoughAddons getInstance() {
        return instance;
    }

    @Nullable
    public static BukkitTask runSync(@Nonnull Runnable runnable) {
        Validate.notNull(runnable, "Cannot run null");

        if (instance == null || !instance.isEnabled()) {
            return null;
        }

        return instance.getServer().getScheduler().runTask(getInstance(), runnable);
    }
}
