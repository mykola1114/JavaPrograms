package org.example.characters;

public interface IWarrior extends CanReceiveDamage, CanAttack, HasHealth {
    static IWarrior newWarrior() {
        return new Warrior(50,5);
    }
    static IWarrior newKnight() {
        return new Warrior(50, 7);
    }
    static IWarrior newDefender() {
        return new Defender(new Warrior(60,3), 2);
    }
    static IWarrior newVampire() {
        return new Vampire(new Warrior(40,4), 50);
    }
    static IWarrior newLancer() {
        return new Lancer(new Warrior(50,6), 50);
    }
    static IWarrior newHealer() {
        return new Healer(new Warrior(60,0),2);
    }
}
