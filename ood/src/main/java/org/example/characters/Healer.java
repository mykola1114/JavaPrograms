package org.example.characters;

public class Healer extends UnitInArmy implements HasAbilityToTreat {
    private int healingPower;

    public Healer(IWarrior warrior, int healingPower) {
        super(warrior);
        this.healingPower = healingPower;
    }

    @Override
    public void boostHealthPower(int value) {
        this.healingPower += value;
    }

    @Override
    public int getHealingPower() {
        return Math.max(0, healingPower);
    }

}

