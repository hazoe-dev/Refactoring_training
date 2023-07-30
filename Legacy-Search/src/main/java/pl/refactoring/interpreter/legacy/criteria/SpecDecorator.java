package pl.refactoring.interpreter.legacy.criteria;

import pl.refactoring.interpreter.legacy.RealEstate;

public abstract class SpecDecorator implements Spec{
    private Spec wrapper;

    public SpecDecorator(Spec wrapper) {
        this.wrapper = wrapper;
    }
    public SpecDecorator() {
        this.wrapper = new BaseSpec();
    }

    @Override
    public boolean check(RealEstate estate) {
        return wrapper.check(estate);
    }
}
