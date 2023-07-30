package pl.refactoring.interpreter.legacy.criteria;

import pl.refactoring.interpreter.legacy.field.EstateMaterial;
import pl.refactoring.interpreter.legacy.RealEstate;

public class MaterialSpec extends SpecDecorator{

    private EstateMaterial material;

    public MaterialSpec(EstateMaterial material) {
        this.material = material;
    }
    public MaterialSpec(Spec spec, EstateMaterial material) {
        super(spec);
        this.material = material;
    }

    public boolean check(RealEstate estate) {
        return super.check(estate) && estate.getMaterial().equals(material);
    }
}