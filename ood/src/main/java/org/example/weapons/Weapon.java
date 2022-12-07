package org.example.weapons;

public class Weapon implements IWeapon{
    private final int health;
    private final int attack;
    private final int defense;
    private final int vampirism;
    private final int healPower;
    public Weapon(int health, int attack, int defense, int vampirism, int healPower) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.vampirism = vampirism;
        this.healPower = healPower;
    }

    @Override
    public int getAttckBonus() {
        return attack;
    }
    @Override
    public int getDefenseBonus() {
        return defense;
    }
    @Override
    public int getHealPowerBonus() {
        return healPower;
    }
    @Override
    public int getVampirismBonus() {
        return vampirism;
    }
    @Override
    public int getHealBonus(){
        return health;
    }

}
