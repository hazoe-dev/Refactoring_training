package pl.refactoring.interpreter.legacy;

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
