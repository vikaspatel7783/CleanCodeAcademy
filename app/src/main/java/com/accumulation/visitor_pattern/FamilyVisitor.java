package com.accumulation.visitor_pattern;

interface FamilyVisitor {

    void accept(Family1 family1);

    void accept(Family2 family2);
}
