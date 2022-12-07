package org.example.characters;

public interface CanAttack {
    int getAttack();
    void boostAttack(int value);
    default void hit(CanReceiveDamage w) {
        w.receiveDamage(getAttack());
    }
}
