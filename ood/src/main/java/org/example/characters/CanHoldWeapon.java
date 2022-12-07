package org.example.characters;

import org.example.weapons.IWeapon;

public interface CanHoldWeapon {
    IWeapon getFisrtWeapon();
    IWeapon getSecondWeapon();
    void equipWeapon(IWeapon weapon);
}
