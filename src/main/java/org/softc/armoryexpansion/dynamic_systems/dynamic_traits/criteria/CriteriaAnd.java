package org.softc.armoryexpansion.dynamic_systems.dynamic_traits.criteria;

import slimeknights.tconstruct.library.materials.Material;

import java.util.ArrayList;

public class CriteriaAnd implements ICriteria {
    ArrayList<ICriteria> criteriaList;

    @Override
    public boolean match(Material material) {
        for (ICriteria criteria:criteriaList) {
            if (!criteria.match(material)) return false;
        }
        return true;
    }

    public CriteriaAnd(ArrayList<ICriteria> criteriaList) {
        this.criteriaList = criteriaList;
    }
}
