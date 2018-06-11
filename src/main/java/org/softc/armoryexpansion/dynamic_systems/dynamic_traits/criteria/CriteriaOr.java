package org.softc.armoryexpansion.dynamic_systems.dynamic_traits.criteria;

import slimeknights.tconstruct.library.materials.Material;

import java.util.Collection;

public class CriteriaOr implements ICriteria {
    Collection<ICriteria> criteriaList;

    @Override
    public boolean match(Material material) {
        for (ICriteria criteria:criteriaList) {
            if (criteria.match(material)) return true;
        }
        return false;
    }

    public CriteriaOr(Collection<ICriteria> criteriaList) {
        this.criteriaList = criteriaList;
    }
}
