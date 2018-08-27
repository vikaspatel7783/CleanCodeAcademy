package com.accumulation.visitor_pattern;

import java.util.ArrayList;
import java.util.List;

public class MyMain {

    public int collectContribution() {

        FamilyVisitor familyVisitor = new HeterogeneousFamilyVisitor();

        for (Family family : getFamilies()) {
            family.accept(familyVisitor);
        };

        return ((HeterogeneousFamilyVisitor)familyVisitor).getTotalContribution();

    }

    private List<Family> getFamilies() {
        ArrayList<Family> families = new ArrayList<>();
        families.add(new Family1());
        families.add(new Family2());
        return families;
    }

}
