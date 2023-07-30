package pl.refactoring.interpreter.legacy.criteria;

import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.field.EstateType;

public class EstateTypeSpec implements Spec{
    private EstateType type;
    private RealEstate estate;

    public EstateTypeSpec(EstateType type) {
        this.type = type;
        this.estate = estate;
    }

    public boolean check(RealEstate estate) {
        return this.estate.getType().equals(type);
    }
}
