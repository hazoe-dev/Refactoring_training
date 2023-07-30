package pl.refactoring.interpreter.legacy.criteria;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.field.EstateMaterial;
import pl.refactoring.interpreter.legacy.field.EstatePlacement;
import pl.refactoring.interpreter.legacy.field.EstateType;

import static org.junit.jupiter.api.Assertions.*;

class PlacementSpecTest {
    private RealEstate estate;

    @BeforeEach
    void setUp() {
        estate = new RealEstate(1, 140, EstatePlacement.VILLAGE,
                EstateType.BUNGALLOW, EstateMaterial.WOOD);
    }
    @Test
    void check_whenEstateIsVillageAndPlacementIsVillage_returnTrue() {
        //arrange
        PlacementSpec placementSpec = new PlacementSpec(EstatePlacement.VILLAGE);
        //act
        boolean isVillagePlacement = placementSpec.check(estate);
        //assert
        Assertions.assertEquals(true, isVillagePlacement);
    }

    @Test
    void check_whenEstateIsVillageAndPlacementIsTown_returnFalse() {
        //arrange
        PlacementSpec placementSpec = new PlacementSpec(EstatePlacement.TOWN);
        //act
        boolean isTownPlacement = placementSpec.check(estate);
        //assert
        Assertions.assertEquals(false, isTownPlacement);
    }
}