package com.accumulation.visitor_pattern;

public class Family1 implements Family {


    @Override
    public void accept(FamilyVisitor familyVisitor) {
        familyVisitor.accept(this);
    }

    @Override
    public int getContribution() {
        return 20;
    }
}
