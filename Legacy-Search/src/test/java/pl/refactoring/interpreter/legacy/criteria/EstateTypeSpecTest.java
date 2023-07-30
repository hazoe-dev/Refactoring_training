package pl.refactoring.interpreter.legacy.criteria;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.field.EstateMaterial;
import pl.refactoring.interpreter.legacy.field.EstatePlacement;
import pl.refactoring.interpreter.legacy.field.EstateType;

import static org.junit.jupiter.api.Assertions.*;

class EstateTypeSpecTest {
    private RealEstate estate;

    @BeforeEach
    void setUp() {
        estate = new RealEstate(1, 140, EstatePlacement.VILLAGE,
                EstateType.HOUSE, EstateMaterial.WOOD);
    }
    @Test
    void check_whenEstateTypeIsHouseAndTypeIsHouse_returnTrue() {
        //arrange
        EstateTypeSpec typeSpec = new EstateTypeSpec(EstateType.HOUSE);
        //act
        boolean isHouseType = typeSpec.check(estate);
        //assert
        Assertions.assertEquals(true,isHouseType);
    }

    @Test
    void check_whenEstateTypeIsHouseAndTypeIsHouse_returnFalse() {
        //arrange
        EstateTypeSpec typeSpec = new EstateTypeSpec(EstateType.BUNGALLOW);
        //act
        boolean isBUNGALLOWType = typeSpec.check(estate);
        //assert
        Assertions.assertEquals(false,isBUNGALLOWType);
    }
}