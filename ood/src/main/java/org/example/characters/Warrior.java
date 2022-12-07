package org.example.characters;

public class Warrior implements IWarrior {
    private int initialHealth;
    private int health;
    private int attack;


    public Warrior(int health, int attack) {
        this.initialHealth = health;
        this.health = health;
        this.attack = attack;
    }

    void setHealth(int value) {
        this.health = value;
    }

    @Override
    public void boostAttack(int value) {
        this.attack += value;
    }
    @Override
    public void boostHealth(int value) {
        this.health += value;
        this.initialHealth += value;
    }
    @Override
    public void healby(int healing) {
        if (healing >= 0) {
            var newHealth = Math.min(getInitialHealth(), getHealth()+healing);
            setHealth(newHealth);
        }
        else throw new IllegalArgumentException("Healing has negative value");
    }
    @Override
    public int getInitialHealth() {
        return initialHealth;
    }
    @Override
    public int getHealth() {
        return health;
    }
    @Override
    public void receiveDamage(int damage) {
        if (damage >= 0) {
            var newHealth = Math.max(0, getHealth()-damage);
            setHealth(newHealth);
        }
        else throw new IllegalArgumentException("Damage has negative value");
    }
    @Override
    public int getAttack() {
        return attack;
    }

}
