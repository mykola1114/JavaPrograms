package org.example.characters;

interface HasHealth {
    int getInitialHealth();
    int getHealth();
    void boostHealth(int value);
    void healby(int healing);
    default boolean isAlive() {
        return getHealth() > 0;
    }
}
