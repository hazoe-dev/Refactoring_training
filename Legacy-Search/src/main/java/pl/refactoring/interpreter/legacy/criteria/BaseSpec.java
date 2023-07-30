package pl.refactoring.interpreter.legacy.criteria;

import pl.refactoring.interpreter.legacy.RealEstate;

public class BaseSpec implements Spec{
    @Override
    public boolean check(RealEstate estate) {
        return true;
    }
}
