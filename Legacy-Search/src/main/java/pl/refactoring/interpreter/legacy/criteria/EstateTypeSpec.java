package pl.refactoring.interpreter.legacy.criteria;

import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.field.EstateType;

public class EstateTypeSpec extends SpecDecorator{
    private EstateType type;

    public EstateTypeSpec(EstateType type) {
        this.type = type;
    }

    public EstateTypeSpec(Spec spec,EstateType type) {
        super(spec);
        this.type = type;
    }

    public boolean check(RealEstate estate) {
        return super.check(estate) && estate.getType().equals(type);
    }
}
