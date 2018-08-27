package com.accumulation.visitor_pattern;

public class HeterogeneousFamilyVisitor implements FamilyVisitor {

    private int totalContribution;

    @Override
    public void accept(Family1 family1) {
        totalContribution += family1.getContribution();
    }

    @Override
    public void accept(Family2 family2) {
        totalContribution += family2.getContribution();
    }

    public int getTotalContribution() {
        return totalContribution;
    }
}
