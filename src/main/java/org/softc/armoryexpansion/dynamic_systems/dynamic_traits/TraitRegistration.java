package org.softc.armoryexpansion.dynamic_systems.dynamic_traits;

import org.softc.armoryexpansion.ArmoryExpansion;
import org.softc.armoryexpansion.dynamic_systems.dynamic_traits.criteria.CriteriaName;
import org.softc.armoryexpansion.dynamic_systems.dynamic_traits.criteria.CriteriaOr;
import org.softc.armoryexpansion.dynamic_systems.dynamic_traits.criteria.ICriteria;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;

import java.util.Arrays;
import java.util.Collection;

import static c4.conarm.common.armor.traits.ArmorTraits.heavy;

public class TraitRegistration {
    private static DynamicTrait[] traits = {
        new DynamicTrait(heavy,
                new CriteriaOr(Arrays.asList(new ICriteria[]{
                        new CriteriaName("Antimony"),
                        new CriteriaName("Cerium"),
                        new CriteriaName("Dysprosium"),
                        new CriteriaName("Erbium"),
                        new CriteriaName("Europium"),
                        new CriteriaName("Gadolinium"),
                        new CriteriaName("Gallium"),
                        new CriteriaName("Germanium"),
                        new CriteriaName("Holmium"),
                        new CriteriaName("Indium"),
                        new CriteriaName("Lanthanum"),
                        new CriteriaName("Lutetium"),
                        new CriteriaName("Neodymium"),
                        new CriteriaName("Niobium"),
                        new CriteriaName("Praseodymium"),
                        new CriteriaName("Samarium"),
                        new CriteriaName("Tantalum"),
                        new CriteriaName("Terbium"),
                        new CriteriaName("Thulium"),
                        new CriteriaName("Tungsten"),
                        new CriteriaName("Uranium"),
                        new CriteriaName("Ytterbium"),

                        new CriteriaName("Iridium"),
                        new CriteriaName("Osmium"),
                        new CriteriaName("Palladium"),
                        new CriteriaName("Platinum"),
                        new CriteriaName("Rhodium"),
                        new CriteriaName("Ruthenium"),
                        new CriteriaName("Gold"),
                        new CriteriaName("Silver"),

                        new CriteriaName("Chromium"),
                        new CriteriaName("Cobalt"),
                        new CriteriaName("Copper"),
                        new CriteriaName("Iron"),
                        new CriteriaName("Lead"),
                        new CriteriaName("Molybdenum"),
                        new CriteriaName("Nickel"),
                        new CriteriaName("Tin"),
                        new CriteriaName("Zinc"),

                        new CriteriaName("Arsenic"),
                        new CriteriaName("Bismuth"),
                        new CriteriaName("Cadmium"),
                        new CriteriaName("Hafnium"),
                        new CriteriaName("Manganese"),
                        new CriteriaName("Mercury"),
                        new CriteriaName("Proctactinium"),
                        new CriteriaName("Rhenium"),
                        new CriteriaName("Selenium"),
                        new CriteriaName("Tellurium"),
                        new CriteriaName("Thallium"),
                        new CriteriaName("Thorium"),
                        new CriteriaName("Vanadium"),
                        new CriteriaName("Zirconium"),

                        new CriteriaName("Actinium"),
                        new CriteriaName("Americium"),
                        new CriteriaName("Berkelium"),
                        new CriteriaName("Californium"),
                        new CriteriaName("Curium"),
                        new CriteriaName("Dubnium"),
                        new CriteriaName("Einsteinium"),
                        new CriteriaName("Fermium"),
                        new CriteriaName("Mendelevium"),
                        new CriteriaName("Neptunium"),
                        new CriteriaName("Plutonium"),
                        new CriteriaName("Polonium"),
                        new CriteriaName("Promethium"),
                        new CriteriaName("Radium"),
                        new CriteriaName("Technetium"),

                        new CriteriaName("Astatine"),
                        new CriteriaName("Bohrium"),
                        new CriteriaName("Copernicium"),
                        new CriteriaName("Darmstadtium"),
                        new CriteriaName("Flerovium"),
                        new CriteriaName("Hassium"),
                        new CriteriaName("Lawrencium"),
                        new CriteriaName("Livermorium"),
                        new CriteriaName("Meitnerium"),
                        new CriteriaName("Moscovium"),
                        new CriteriaName("Nihonium"),
                        new CriteriaName("Nobelium"),
                        new CriteriaName("Roentgenium"),
                        new CriteriaName("Rutherfordium"),
                        new CriteriaName("Seaborgium"),
                        new CriteriaName("Tennessine")
                })), null)
    };

    public static Collection<DynamicTrait> getTraits() {
        return Arrays.asList(traits);
    }

    private static void applyTraitsToMaterial(Material material, Collection<DynamicTrait> traits) {
        for (DynamicTrait trait:traits) {
            if (trait.apply(material)) {
                ArmoryExpansion.logger.info("Added " + trait.getTrait().getLocalizedName() + " to " + material.getLocalizedName() + " material");
            }
        }
    }

    private static void applyTraitsToAllMaterials(Collection<DynamicTrait> traits) {
        for (Material material:TinkerRegistry.getAllMaterials()) {
            applyTraitsToMaterial(material, traits);
        }
    }

    public static void applyGlobalTraitListToAllMaterials() {
        applyTraitsToAllMaterials(Arrays.asList(traits));
    }
}
