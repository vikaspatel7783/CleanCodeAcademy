package com.accumulation.visitor_pattern;

public class Family2 implements Family {

    @Override
    public void accept(FamilyVisitor familyVisitor) {
        familyVisitor.accept(this);
    }

    @Override
    public int getContribution() {
        return 30;
    }
}
