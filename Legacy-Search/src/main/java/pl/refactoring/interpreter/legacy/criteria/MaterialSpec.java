package pl.refactoring.interpreter.legacy.criteria;

import pl.refactoring.interpreter.legacy.field.EstateMaterial;
import pl.refactoring.interpreter.legacy.RealEstate;

public class MaterialSpec implements Spec {

    private EstateMaterial material;

    public MaterialSpec(EstateMaterial material) {
        this.material = material;
    }

    public boolean check(RealEstate estate) {
        return estate.getMaterial().equals(material);
    }
}