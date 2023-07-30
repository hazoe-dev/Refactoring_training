package pl.refactoring.interpreter.legacy.criteria;

import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.field.EstatePlacement;

public class PlacementSpec extends SpecDecorator {
    private EstatePlacement placement;
    private boolean isEqual;

    public PlacementSpec(EstatePlacement placement, boolean isEqual) {
        this.placement = placement;
        this.isEqual = isEqual;
    }

    public PlacementSpec( Spec spec,EstatePlacement placement, boolean isEqual) {
        super(spec);
        this.placement = placement;
        this.isEqual = isEqual;
    }

    private boolean checkEqual(RealEstate estate) {
        return estate.getPlacement().equals(placement);
    }

    public boolean check(RealEstate estate) {
        return super.check(estate) && isEqual ? checkEqual(estate) : !checkEqual(estate);
    }
}
