package org.softc.armoryexpansion.dynamic_systems.dynamic_materials.constructs_armory;

import c4.conarm.lib.materials.CoreMaterialStats;
import c4.conarm.lib.materials.PlatesMaterialStats;
import c4.conarm.lib.materials.TrimMaterialStats;
import org.softc.armoryexpansion.dynamic_systems.dynamic_materials.Config;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.tools.TinkerMaterials;

import static c4.conarm.lib.materials.ArmorMaterialType.CORE;
import static c4.conarm.lib.materials.ArmorMaterialType.PLATES;
import static c4.conarm.lib.materials.ArmorMaterialType.TRIM;
import static org.softc.armoryexpansion.util.Math.clamp;
import static slimeknights.tconstruct.library.materials.MaterialTypes.EXTRA;
import static slimeknights.tconstruct.library.materials.MaterialTypes.HANDLE;
import static slimeknights.tconstruct.library.materials.MaterialTypes.HEAD;

final class StatRegistration {
    private static final float STAT_MULT = 1.25f;
    private static final int DURA_MIN = 1;
    private static final int DURA_MAX = 120;
    private static final int DEF_MIN = 0;
    private static final int DEF_MAX = 50;
    private static final int TOUGH_MIN = DEF_MIN / 10;
    private static final int TOUGH_MAX = DEF_MAX / 10;

    private static void registerCoreMaterialStat(final Material material) {
        final HeadMaterialStats materialHead = material.getStats(HEAD);
        final HeadMaterialStats ironHead = TinkerMaterials.iron.getStats(HEAD);
        final CoreMaterialStats ironCore = TinkerMaterials.iron.getStats(CORE);

        float durability = clamp(ironCore.durability * materialHead.durability / ironHead.durability / STAT_MULT, DURA_MIN, DURA_MAX);
        float defense = clamp(1.5f * ironCore.defense * materialHead.attack / ironHead.attack  / STAT_MULT, DEF_MIN,DEF_MAX);

        TinkerRegistry.addMaterialStats(material, new CoreMaterialStats(durability, defense));
    }

    private static void registerPlatesMaterialStat(final Material material) {
        final HandleMaterialStats materialHandle = material.getStats(HANDLE);
        final HandleMaterialStats ironHandle = TinkerMaterials.iron.getStats(HANDLE);
        final PlatesMaterialStats ironPlates = TinkerMaterials.iron.getStats(PLATES);

        final float ironPlatesToughness = ironPlates.toughness > 0f ? ironPlates.toughness : 1;

        float durability = clamp(ironPlates.durability * materialHandle.durability / ironHandle.durability / STAT_MULT, DURA_MIN, DURA_MAX);
        float toughness = clamp(3 * ironPlatesToughness * materialHandle.durability / ironHandle.durability / STAT_MULT, TOUGH_MIN, TOUGH_MAX);

        TinkerRegistry.addMaterialStats(material, new PlatesMaterialStats(materialHandle.modifier, durability, toughness));
    }

    private static void registerTrimMaterialStat(final Material material) {
        final ExtraMaterialStats materialExtra = material.getStats(EXTRA);
        final ExtraMaterialStats ironExtra = TinkerMaterials.iron.getStats(EXTRA);
        final TrimMaterialStats ironTrim = TinkerMaterials.iron.getStats(TRIM);

        float extra = 2 * ironTrim.extraDurability * materialExtra.extraDurability / ironExtra.extraDurability / STAT_MULT;

        TinkerRegistry.addMaterialStats(material, new TrimMaterialStats(extra));
    }

    private static Boolean handleCoreStats(int index, Material material){
        if (Config.hasCoreProperty(index) && Config.getCoreProperty(index).getBoolean()){
            registerCoreMaterialStat(material);
            return true;
        }
        return false;
    }

    private static Boolean handlePlatesStats(int index, Material material){
        if (Config.hasPlatesProperty(index) && Config.getPlatesProperty(index).getBoolean()){
            registerPlatesMaterialStat(material);
            return true;
        }
        return false;
    }

    private static Boolean handleTrimStats(int index, Material material){
        if (Config.hasTrimProperty(index) && Config.getTrimProperty(index).getBoolean()){
            registerTrimMaterialStat(material);
            return true;
        }
        return false;
    }

    static Boolean handleArmorStats(int index, Material material){
        if (Config.hasMaterialProperty(index) && Config.getMaterialProperty(index).getBoolean()){
            handleCoreStats(index, material);
            handlePlatesStats(index, material);
            handleTrimStats(index, material);
            return true;
        }
        return false;
    }
}
