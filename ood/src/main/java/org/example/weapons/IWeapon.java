package org.example.weapons;

public interface IWeapon extends CanHeal, CanAttack, CanDefense, CanDoVampirism, CanDoHealPower {
    static IWeapon newSword() {
        return new Weapon(5,2,0,0,0);
    }
    static IWeapon newShield() {
        return new Weapon(20, -1,2,0,0);
    }
    static IWeapon newGreatAxe() {
        return new Weapon(-15, 5,-2,10,0);
    }
    static IWeapon newKatana() {
        return new Weapon(-20, 6,-5,50,0);
    }
    static IWeapon newMagicWand() {
        return new Weapon(30, 3,2,0,3);
    }
    static IWeapon newSuperTool() {
        return new Weapon(200, 20,10,100,10);
    }
}
