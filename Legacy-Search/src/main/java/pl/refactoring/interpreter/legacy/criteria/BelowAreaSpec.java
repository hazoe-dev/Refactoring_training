package pl.refactoring.interpreter.legacy.criteria;

import pl.refactoring.interpreter.legacy.RealEstate;

/**
 * @author tqvu
 */
public class BelowAreaSpec implements Spec {
    public float getMaxBuildingArea() {
        return maxBuildingArea;
    }

    private float maxBuildingArea;

    public BelowAreaSpec(float maxBuildingArea) {
        this.maxBuildingArea = maxBuildingArea;
    }

    @Override
    public boolean check(RealEstate estate) {
        return estate.getBuildingArea() < maxBuildingArea;
    }
}
