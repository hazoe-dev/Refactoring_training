package pl.refactoring.interpreter.legacy.criteria;

import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.field.EstateType;

public class EstateTypeSpec {
    private EstateType type;
    private RealEstate estate;

    public EstateTypeSpec(EstateType type, RealEstate estate) {
        this.type = type;
        this.estate = estate;
    }

    public boolean check() {
        return estate.getType().equals(type);
    }
}
