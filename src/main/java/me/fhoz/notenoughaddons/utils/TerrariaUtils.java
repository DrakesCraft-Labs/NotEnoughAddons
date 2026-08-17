package me.fhoz.notenoughaddons.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.concurrent.ThreadLocalRandom;

public final class TerrariaUtils {
    private TerrariaUtils() {
    }

    public static Vector fastNormalize(Vector v) {
        float length = fastLength(v);
        v.multiply(length);

        return v;
    }

    public static float fastLength(Vector v) {
        double x = v.getX();
        double y = v.getY();
        double z = v.getZ();

        return fastSqrt(x * x + y * y + z * z);
    }

    public static float fastSqrt(double double_num) {
        int i;
        float x2, y;
        float threehalfs = 1.5F;
        float num = (float) double_num;

        x2 = num * 0.5F;
        y = num;
        i = Float.floatToIntBits(y);
        i = 0x5f3759df - (i >> 1);
        y = Float.intBitsToFloat(i);
        y = y * (threehalfs - (x2 * y * y));

        return y;
    }


    public static Vector knockback(Location l1, Location l2, double k) {
        Vector ray = new Vector(l1.getX() - l2.getX(), l1.getY() - l2.getY(), l1.getZ() - l2.getZ());
        Vector kbVector = fastNormalize(ray).multiply(k / 6);
        return kbVector;
    }

    public static void castDamage(EntityDamageByEntityEvent e, Player p, ItemStack item, double critChance, double dmg, double knockback, int useTime) {
        Material mat = item.getType();
        if (p.hasCooldown(mat)) {
            e.setDamage(0);
            e.setCancelled(true);
            return;
        }
        int TICK_DELAY = Math.floorDiv(useTime, 60) * 20;
        Boolean isCrit = false;
        double d = Math.random();
        Location eLoc = e.getEntity().getLocation();
        Location pLoc = p.getLocation();
        if (d < critChance) {
            isCrit = true;
        }
        dmg = (ThreadLocalRandom.current().nextDouble(1.15 - 0.85) + 0.85) * dmg;
        e.setDamage(dmg * (isCrit ? 2 : 1));
        e.getEntity().setVelocity(knockback(eLoc, pLoc, knockback).multiply(isCrit ? 1.4 : 1));
        p.setCooldown(mat, TICK_DELAY);
    }

    public static String useTimeConv(int t) {
        if (t <= 8) {
            return "&fsúper rápido";
        } else if (9 <= t && t <= 20) {
            return "&fpronto";
        } else if (21 <= t && t <= 25) {
            return "&frápido";
        } else if (26 <= t && t <= 30) {
            return "&fcomún";
        } else if (31 <= t && t <= 35) {
            return "&flento";
        } else if (36 <= t && t <= 45) {
            return "&fmuy lento";
        } else if (46 <= t && t <= 55) {
            return "&fExtremadamente lento";
        } else {
            return "&fcaracoles";
        }
    }

    public static String kbConv(double k) {
        if (k == 0) {
            return "&fSin retroceso";
        } else if (k <= 1.5) {
            return "&fRechazo muy débil";
        } else if (k <= 3) {
            return "&fRechazo muy débil";
        } else if (k <= 4) {
            return "&fRechazo débil";
        } else if (k <= 6) {
            return "&fRechazo normal";
        } else if (k <= 7) {
            return "&fFuerte poder de retroceso";
        } else if (k <= 9) {
            return "&fRechazo muy fuerte";
        } else if (k <= 11) {
            return "&fPoder de retroceso extremadamente fuerte";
        } else if (k > 11) {
            return "&fPoder de retroceso loco";
        }
        return "&fRechazo desconocido";
    }

    public static String getDMG(double d) {

        return "&f" + (int) d + " daño cuerpo a cuerpo";
    }

    public static String getCC(double c) {
        return "&f" + (int) c * 100 + "% Tasa de golpes críticos";
    }
}

