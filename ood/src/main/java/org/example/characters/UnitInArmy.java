package org.example.characters;

import org.example.weapons.IWeapon;

import java.util.NoSuchElementException;

public class UnitInArmy implements IWarrior, HasWarriorBehind, CanHoldWeapon {
    private IWarrior warrior;
    private IWeapon weapon;
    private IWeapon secondWeapon;
    private UnitInArmy behind;

    public UnitInArmy(IWarrior warrior) {
        this.warrior = warrior;
    }

    protected IWarrior getKernel() {
        if (warrior instanceof UnitInArmy) {
            return getKernel();
        } else {
            return warrior;
        }
    }
    public UnitInArmy getWarriorBehind() {
        return behind;
    }
    public void setWarriorBehind(UnitInArmy w) {
        behind = w;
    }
    private void setWeapon(IWeapon weap){
        if (weapon == null) {
            this.weapon = weap;
        }
        else {
            if (secondWeapon == null) {
                this.secondWeapon = weap;
            } else {
                throw new NoSuchElementException("You can have only two weapons, one for each hand");
            }
        }
    }

    @Override
    public void equipWeapon(IWeapon weapon){
        setWeapon(weapon);
        boostHealth(weapon.getHealBonus());
        boostAttack(weapon.getAttckBonus());
        if (warrior instanceof HasVampirism){
            ((HasVampirism) warrior).boostVampirism(weapon.getVampirismBonus());
        }
        if (warrior instanceof HasDefence){
            ((HasDefence) warrior).boostDefense(weapon.getDefenseBonus());
        }
        if (warrior instanceof HasAbilityToTreat){
            ((HasAbilityToTreat) warrior).boostHealthPower(weapon.getHealPowerBonus());
        }
    }
    @Override
    public IWeapon getFisrtWeapon() {
        return weapon;
    }
    @Override
    public IWeapon getSecondWeapon() {
        return secondWeapon;
    }
    @Override
    public int getInitialHealth() {
        return warrior.getInitialHealth();
    }
    @Override
    public int getAttack() {
        return warrior.getAttack();
    }
    @Override
    public void boostAttack(int value) {
        warrior.boostAttack(value);
    }
    @Override
    public void boostHealth(int value) {
        warrior.boostHealth(value);
    }
    @Override
    public void healby(int healing) {
        warrior.healby(healing);
    }
    @Override
    public int getHealth() {
        return warrior.getHealth();
    }
    @Override
    public boolean isAlive() {
        return warrior.isAlive();
    }
    @Override
    public void hit(CanReceiveDamage w) {
        warrior.hit(w);
        if (warrior instanceof HasWarriorBehind) {
            var next = ((HasWarriorBehind) warrior).getWarriorBehind();
            if (next != null && next instanceof HasAbilityToTreat) {
                var healingValue = ((HasAbilityToTreat) next).getHealingPower();
                warrior.healby(healingValue);
            }
        }
    }
    @Override
    public void receiveDamage(int damage) {
        warrior.receiveDamage(damage);
    }
}
