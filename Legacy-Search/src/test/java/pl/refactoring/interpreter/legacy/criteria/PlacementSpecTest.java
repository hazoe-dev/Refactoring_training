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
    void check_equalWhenEstateIsVillageAndPlacementIsVillage_returnTrue() {
        //arrange
        PlacementSpec placementSpec = new PlacementSpec(EstatePlacement.VILLAGE, true);
        //act
        boolean isVillagePlacement = placementSpec.check(estate);
        //assert
        Assertions.assertEquals(true, isVillagePlacement);
    }

    @Test
    void check_equalWhenEstateIsVillageAndPlacementIsTown_returnFalse() {
        //arrange
        PlacementSpec placementSpec = new PlacementSpec(EstatePlacement.TOWN,true);
        //act
        boolean isTownPlacement = placementSpec.check(estate);
        //assert
        Assertions.assertEquals(false, isTownPlacement);
    }

    @Test
    void check_notEqualWhenEstateIsVillageAndPlacementIsVillage_returnFalse() {
        //arrange
        PlacementSpec placementSpec = new PlacementSpec(EstatePlacement.VILLAGE, false);
        //act
        boolean isVillagePlacement = placementSpec.check(estate);
        //assert
        Assertions.assertEquals(false, isVillagePlacement);
    }

    @Test
    void check_notEqualWhenEstateIsVillageAndPlacementIsTown_returnTrue() {
        //arrange
        PlacementSpec placementSpec = new PlacementSpec(EstatePlacement.TOWN,false);
        //act
        boolean isTownPlacement = placementSpec.check(estate);
        //assert
        Assertions.assertEquals(true, isTownPlacement);
    }
}