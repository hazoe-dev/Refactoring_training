package pl.refactoring.interpreter.legacy.criteria;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.field.EstateMaterial;
import pl.refactoring.interpreter.legacy.field.EstatePlacement;
import pl.refactoring.interpreter.legacy.field.EstateType;
import pl.refactoring.interpreter.legacy.criteria.MaterialSpec;

class MaterialSpecTest {
    RealEstate estate;
    @BeforeEach
    void setUp() {
        estate = new RealEstate(1, 140, EstatePlacement.VILLAGE,
                EstateType.BUNGALLOW, EstateMaterial.WOOD);
    }

    @Test
    void check_whenEstateIsWoodAndMaterialIsStone_returnFalse() {
        //arrange
        MaterialSpec materialSpec = new MaterialSpec(EstateMaterial.STONE);
        //act
        boolean isStoneMaterial = materialSpec.check(estate);
        //assert
        Assertions.assertEquals(false, isStoneMaterial);
    }

    @Test
    void check_whenEstateIsWoodAndMaterialIsWood_returnTrue() {
        //arrange
        MaterialSpec materialSpec = new MaterialSpec(EstateMaterial.WOOD);
        //act
        boolean isStoneMaterial = materialSpec.check(estate);
        //assert
        Assertions.assertEquals(true, isStoneMaterial);
    }


}