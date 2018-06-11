package org.softc.armoryexpansion.dynamic_systems.dynamic_traits.criteria;

import slimeknights.tconstruct.library.materials.Material;

public class CriteriaName implements ICriteria {
    private String name;

    @Override
    public boolean match(Material material) {
        return name.equals(material.getLocalizedName());
    }

    public CriteriaName(String name) {
        this.name = name;
    }
}
