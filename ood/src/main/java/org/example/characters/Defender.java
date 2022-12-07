package org.example.characters;

public class Defender extends UnitInArmy implements HasDefence {
    private int defence;

    public Defender(IWarrior warrior, int defence){
        super(warrior);
        this.defence = defence;
    }

    @Override
    public void boostDefense(int value) {
        this.defence += value;
    }

    @Override
    public int getDefence() {
        return defence;
    }
    @Override
    public void receiveDamage(int damage) {
        var reducedDamage = Math.max(0, damage - Math.max(0, getDefence()));
        super.receiveDamage(reducedDamage);
    }
}