package pl.refactoring.interpreter.legacy.criteria;

import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.field.EstatePlacement;

public class PlacementSpec {
    private EstatePlacement placement;
    private RealEstate estate;

    public PlacementSpec(EstatePlacement placement) {
        this.placement = placement;
        this.estate = estate;
    }

    public boolean check(RealEstate estate) {
        return this.estate.getPlacement().equals(placement);
    }
}
