package pl.refactoring.interpreter.legacy.criteria;

import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.field.EstateType;

public class EstateTypeSpec implements Spec{
    private EstateType type;

    public EstateTypeSpec(EstateType type) {
        this.type = type;
    }

    public boolean check(RealEstate estate) {
        return estate.getType().equals(type);
    }
}
