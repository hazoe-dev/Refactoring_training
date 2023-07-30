package pl.refactoring.interpreter.legacy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.refactoring.interpreter.legacy.field.EstateMaterial;
import pl.refactoring.interpreter.legacy.field.EstatePlacement;
import pl.refactoring.interpreter.legacy.field.EstateType;
import pl.refactoring.interpreter.legacy.criteria.BelowAreaSpec;

class BelowAreaSpecTest {

    private RealEstate estate;

    @BeforeEach
    void setUp() {
        estate = new RealEstate(1, 140, EstatePlacement.VILLAGE,
                EstateType.BUNGALLOW, EstateMaterial.WOOD);
    }

    @Test
    void check_whenBuildingAreaIsLowerThanMaxArea_returnTrue() {
        //arrange
        BelowAreaSpec belowAreaSpec = new BelowAreaSpec(150);
        //act
        boolean isBelowArea = belowAreaSpec.check(estate);
        //assert
        Assertions.assertEquals(true, isBelowArea);
    }

    @Test
    void check_whenBuildingAreaIsLargerThanMaxArea_returnFalse() {
        //arrange
        BelowAreaSpec belowAreaSpec = new BelowAreaSpec(50);
        //act
        boolean isBelowArea = belowAreaSpec.check(estate);
        //assert
        Assertions.assertEquals(false, isBelowArea);
    }
}