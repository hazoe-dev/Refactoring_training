package pl.refactoring.interpreter.legacy.criteria;

import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.field.EstatePlacement;

public class PlacementSpec implements Spec{
    private EstatePlacement placement;

    public PlacementSpec(EstatePlacement placement) {
        this.placement = placement;
    }

    public boolean check(RealEstate estate) {
        return estate.getPlacement().equals(placement);
    }
}
