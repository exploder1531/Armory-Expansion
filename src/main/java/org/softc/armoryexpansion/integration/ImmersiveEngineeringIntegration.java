package org.softc.armoryexpansion.integration;

import blusunrize.immersiveengineering.ImmersiveEngineering;
import com.mcmoddev.lib.integration.plugins.ConstructsArmory;
import com.mcmoddev.lib.integration.plugins.TinkersConstruct;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.softc.armoryexpansion.ArmoryExpansion;
import org.softc.armoryexpansion.integration.lib.AbstractIntegration;

@Mod(
        modid = ImmersiveEngineeringIntegration.MODID,
        name = ImmersiveEngineeringIntegration.NAME,
        version = ArmoryExpansion.VERSION,
        dependencies = ImmersiveEngineeringIntegration.DEPENDENCIES
)
@Mod.EventBusSubscriber
public class ImmersiveEngineeringIntegration extends AbstractIntegration {
    static final String MODID = ArmoryExpansion.MODID + "-" + ImmersiveEngineering.MODID;
    static final String NAME = "Armory Expansion - " + ImmersiveEngineering.MODNAME;
    static final String DEPENDENCIES =
            "required-after:" + TinkersConstruct.PLUGIN_MODID + "; " +
            "required-after:" + ConstructsArmory.PLUGIN_MODID + "; " +
//                    "required-after:" + ArmoryExpansion.MODID + "; " +
            "required-after:" + ImmersiveEngineering.MODID + "; ";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        setMaterials();
        super.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @Override
    protected void setMaterials() {

    }
}
