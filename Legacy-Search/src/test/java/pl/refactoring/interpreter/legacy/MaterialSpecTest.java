package pl.refactoring.interpreter.legacy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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