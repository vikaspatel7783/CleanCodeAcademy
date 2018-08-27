package com.accumulation.visitor_pattern;

interface Family {

    void accept(FamilyVisitor FamilyVisitor);

    int getContribution();

}
