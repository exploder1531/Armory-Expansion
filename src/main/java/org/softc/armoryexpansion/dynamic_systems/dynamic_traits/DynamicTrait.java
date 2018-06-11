package org.softc.armoryexpansion.dynamic_systems.dynamic_traits;

import org.softc.armoryexpansion.dynamic_systems.dynamic_traits.criteria.ICriteria;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.traits.ITrait;

public class DynamicTrait {
     private ICriteria criteria;
     private ITrait trait;
     private String dependency;

     public ICriteria getCriteria() {
         return criteria;
     }

     public ITrait getTrait() {
         return trait;
     }

     public String getDependency() {
         return dependency;
     }

     public DynamicTrait(ITrait trait, ICriteria criteria, String dependency) {
         this.criteria = criteria;
         this.trait = trait;
         this.dependency = dependency;
     }

     public boolean match(Material material) {
         return criteria.match(material);
     }

     public boolean apply(Material material) {
         if (match(material)) {
             if (material.getAllTraits().contains(trait)) {
                 return true;
             }
             else {
                 if (dependency == null) {
                     material.addTrait(trait);
                 }
                 else {
                     material.addTrait(trait, dependency);
                 }
                 return true;
             }
         }
         return false;
     }
}
