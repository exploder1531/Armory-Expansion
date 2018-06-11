package org.softc.armoryexpansion.dynamic_systems.dynamic_traits.criteria;

import slimeknights.tconstruct.library.materials.Material;

public interface ICriteria {
    boolean match(Material material);
}
