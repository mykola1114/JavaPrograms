package org.example;

import org.example.characters.UnitInArmy;
import org.example.weapons.IWeapon;
import org.example.weapons.Weapon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.example.characters.IWarrior;


class FightTest {
    @Test
    @DisplayName("1. Fight")
    void Fight1() {
        var carl = new UnitInArmy(IWarrior.newWarrior());
        var jim = new UnitInArmy(IWarrior.newKnight());

        assert Battle.fight(carl, jim) == false;
    }

    @Test
    @DisplayName("2. Fight")
    void Fight2() {
        var ramon = new UnitInArmy(IWarrior.newKnight());
        var slevin = new UnitInArmy(IWarrior.newWarrior());

        assert Battle.fight(ramon, slevin) == true;
    }

    @Test
    @DisplayName("3. Fight")
    void Fight3() {
        var bob = new UnitInArmy(IWarrior.newWarrior());
        var mars = new UnitInArmy(IWarrior.newWarrior());
        Battle.fight(bob, mars);

        assert bob.isAlive() == true;
    }

    @Test
    @DisplayName("4. Fight")
    void Fight4() {
        var zeus = new UnitInArmy(IWarrior.newKnight());
        var godkiller = new UnitInArmy(IWarrior.newWarrior());
        Battle.fight(zeus, godkiller);

        assert zeus.isAlive() == true;
    }

    @Test
    @DisplayName("5. Fight")
    void Fight5() {
        var husband = new UnitInArmy(IWarrior.newWarrior());
        var wife = new UnitInArmy(IWarrior.newWarrior());
        Battle.fight(husband, wife);

        assert wife.isAlive() == false;
    }

    @Test
    @DisplayName("6. Fight")
    void Fight6() {
        var dragon = new UnitInArmy(IWarrior.newWarrior());
        var knight = new UnitInArmy(IWarrior.newKnight());
        Battle.fight(dragon, knight);

        assert knight.isAlive() == true;
    }

    @Test
    @DisplayName("7. Fight")
    void Fight7() {
        var unit_1 = new UnitInArmy(IWarrior.newWarrior());
        var unit_2 = new UnitInArmy(IWarrior.newKnight());
        var unit_3 = new UnitInArmy(IWarrior.newWarrior());
        Battle.fight(unit_1, unit_2);

        assert Battle.fight(unit_2, unit_3) == false;
    }

    @Test
    @DisplayName("1. Battle")
    void Battle1() {
        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 1);
        army_2.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 2);

        assert Battle.fight(army_1, army_2) == false;
    }

    @Test
    @DisplayName("2. Battle")
    void Battle2() {
        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 2);
        army_2.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 3);

        assert Battle.fight(army_1, army_2) == false;
    }

    @Test
    @DisplayName("3. Battle")
    void Battle3() {
        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newWarrior()), 5);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newWarrior()), 7);

        assert Battle.fight(army_1, army_2) == false;
    }

    @Test
    @DisplayName("4. Battle")
    void Battle4() {
        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 20);
        army_2.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 21);

        assert Battle.fight(army_1, army_2) == true;
    }

    @Test
    @DisplayName("5. Battle")
    void Battle5() {
        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 10);
        army_2.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 11);

        assert Battle.fight(army_1, army_2) == true;
    }

    @Test
    @DisplayName("6. Battle")
    void Battle6() {
        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 11);
        army_2.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 7);

        assert Battle.fight(army_1, army_2) == true;
    }

    @Test
    @DisplayName("7. Battle")
    void Battle7() {
        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 5);
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newDefender()), 4);
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newDefender()), 5);
        army_2.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 4);

        assert Battle.fight(army_1, army_2) == true;
    }

    @Test
    @DisplayName("8. Battle")
    void Battle8() {
        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newDefender()), 5);
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 20);
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 21);
        army_2.addUnits(() ->  new UnitInArmy(IWarrior.newDefender()), 4);

        assert Battle.fight(army_1, army_2) == true;
    }

    @Test
    @DisplayName("9. Battle")
    void Battle9() {
        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 10);
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newDefender()), 5);
        army_2.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 5);
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newDefender()), 10);

        assert Battle.fight(army_1, army_2) == true;
    }

    @Test
    @DisplayName("10. Battle")
    void Battle10() {
        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newDefender()), 2);
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 1);
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newDefender()), 1);
        army_2.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 5);

        assert Battle.fight(army_1, army_2) == false;
    }

    @Test
    @DisplayName("11. Battle")
    void Battle11() {
        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newDefender()), 5);
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newVampire()), 6);
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 7);
        army_2.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 6);
        army_2.addUnits(() ->  new UnitInArmy(IWarrior.newDefender()), 6);
        army_2.addUnits(() ->  new UnitInArmy(IWarrior.newVampire()), 6);

        assert Battle.fight(army_1, army_2) == false;
    }

    @Test
    @DisplayName("12. Battle")
    void Battle12() {
        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newDefender()), 2);
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newVampire()), 3);
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 4);
        army_2.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 4);
        army_2.addUnits(() ->  new UnitInArmy(IWarrior.newDefender()), 4);
        army_2.addUnits(() ->  new UnitInArmy(IWarrior.newVampire()), 3);

        assert Battle.fight(army_1, army_2) == false;
    }

    @Test
    @DisplayName("13. Battle")
    void Battle13() {
        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newDefender()), 11);
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newVampire()), 3);
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 4);
        army_2.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 4);
        army_2.addUnits(() ->  new UnitInArmy(IWarrior.newDefender()), 4);
        army_2.addUnits(() ->  new UnitInArmy(IWarrior.newVampire()), 13);

        assert Battle.fight(army_1, army_2) == true;
    }

    @Test
    @DisplayName("14. Battle")
    void Battle14() {
        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newDefender()), 9);
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newVampire()), 3);
        army_1.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 8);
        army_2.addUnits(() ->  new UnitInArmy(IWarrior.newWarrior()), 4);
        army_2.addUnits(() ->  new UnitInArmy(IWarrior.newDefender()), 4);
        army_2.addUnits(() ->  new UnitInArmy(IWarrior.newVampire()), 13);

        assert Battle.fight(army_1, army_2) == true;
    }

    @Test
    @DisplayName("15. Battle")
    void Battle15() {
        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newLancer()), 5);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newVampire()), 3);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newWarrior()), 4);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newDefender()), 2);

        army_2.addUnits(() -> new UnitInArmy(IWarrior.newWarrior()), 4);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newDefender()), 4);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newVampire()), 6);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newLancer()), 5);

        assert Battle.fight(army_1, army_2) == false;
    }

    @Test
    @DisplayName("16. Battle")
    void Battle16() {
        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newLancer()), 7);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newVampire()), 3);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newWarrior()), 4);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newDefender()), 2);

        army_2.addUnits(() -> new UnitInArmy(IWarrior.newWarrior()), 4);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newDefender()), 4);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newVampire()), 6);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newLancer()), 4);

        assert Battle.fight(army_1, army_2) == true;
    }

    @Test
    @DisplayName("17. Battle")
    void Battle17() {
        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newLancer()), 7);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newVampire()), 3);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newHealer()), 1);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newWarrior()), 4);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newHealer()), 1);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newDefender()), 2);

        army_2.addUnits(() -> new UnitInArmy(IWarrior.newWarrior()), 4);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newDefender()), 4);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newHealer()), 1);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newVampire()), 6);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newLancer()), 4);

        assert Battle.fight(army_1, army_2) == true;
    }

    @Test
    @DisplayName("18. Battle")
    void Battle18() {
        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newLancer()), 1);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newWarrior()), 3);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newHealer()), 1);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newWarrior()), 4);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newHealer()), 1);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newKnight()), 2);

        army_2.addUnits(() -> new UnitInArmy(IWarrior.newWarrior()), 4);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newDefender()), 4);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newHealer()), 1);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newVampire()), 6);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newLancer()), 4);

        assert Battle.fight(army_1, army_2) == false;
    }

    @Test
    @DisplayName("19. Battle")
    void Battle19() {
        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newLancer()), 5);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newVampire()), 3);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newWarrior()), 4);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newDefender()), 2);

        army_2.addUnits(() -> new UnitInArmy(IWarrior.newWarrior()), 4);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newDefender()), 4);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newVampire()), 6);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newLancer()), 5);

        assert Battle.straightFight(army_1, army_2) == false;
    }

    @Test
    @DisplayName("20. Battle")
    void Battle20() {
        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newLancer()), 7);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newVampire()), 4);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newWarrior()), 4);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newDefender()), 2);

        army_2.addUnits(() -> new UnitInArmy(IWarrior.newWarrior()), 4);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newDefender()), 4);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newVampire()), 6);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newLancer()), 4);

        assert Battle.straightFight(army_1, army_2) == true;
    }

    @Test
    @DisplayName("21. Battle")
    void Battle21() {
        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newLancer()), 7);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newVampire()), 3);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newHealer()), 1);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newWarrior()), 4);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newHealer()), 1);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newDefender()), 2);

        army_2.addUnits(() -> new UnitInArmy(IWarrior.newWarrior()), 4);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newDefender()), 5);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newHealer()), 1);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newVampire()), 6);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newLancer()), 4);

        assert Battle.straightFight(army_1, army_2) == false;
    }

    @Test
    @DisplayName("22. Battle")
    void Battle22() {
        var army_1 = new Army();
        var army_2 = new Army();
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newLancer()), 4);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newWarrior()), 3);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newHealer()), 1);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newWarrior()), 4);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newHealer()), 1);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newKnight()), 2);

        army_2.addUnits(() -> new UnitInArmy(IWarrior.newWarrior()), 4);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newDefender()), 4);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newHealer()), 1);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newVampire()), 2);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newLancer()), 4);

        assert Battle.straightFight(army_1, army_2) == true;
    }

    @Test
    @DisplayName("1. Weapon")
    void Weapon1() {
        var unit_1 = new UnitInArmy(IWarrior.newWarrior());
        var unit_2 = new UnitInArmy(IWarrior.newVampire());

        var weapon_1 = new Weapon(-10,5,0,40,0);
        var weapon_2 = IWeapon.newSword();

        unit_1.equipWeapon(weapon_1);
        unit_2.equipWeapon(weapon_2);

        assert Battle.fight(unit_1, unit_2) == true;
    }

    @Test
    @DisplayName("2. Weapon")
    void Weapon2() {
        var unit_1 = new UnitInArmy(IWarrior.newDefender());
        var unit_2 = new UnitInArmy(IWarrior.newLancer());

        var weapon_1 = IWeapon.newShield();
        var weapon_2 = IWeapon.newGreatAxe();

        unit_1.equipWeapon(weapon_1);
        unit_2.equipWeapon(weapon_2);

        assert Battle.fight(unit_1, unit_2) == false;
    }

    @Test
    @DisplayName("3. Weapon")
    void Weapon3() {
        var unit_1 = new UnitInArmy(IWarrior.newHealer());
        var unit_2 = new UnitInArmy(IWarrior.newKnight());

        var weapon_1 = IWeapon.newMagicWand();
        var weapon_2 = IWeapon.newKatana();

        unit_1.equipWeapon(weapon_1);
        unit_2.equipWeapon(weapon_2);

        assert Battle.fight(unit_1, unit_2) == false;
    }

    @Test
    @DisplayName("4. Weapon")
    void Weapon4() {
        var unit_1 = new UnitInArmy(IWarrior.newDefender());
        var unit_2 = new UnitInArmy(IWarrior.newVampire());

        var weapon_1 = IWeapon.newShield();
        var weapon_2 = IWeapon.newMagicWand();
        var weapon_3 = IWeapon.newShield();
        var weapon_4 = IWeapon.newKatana();

        unit_1.equipWeapon(weapon_1);
        unit_1.equipWeapon(weapon_2);
        unit_2.equipWeapon(weapon_3);
        unit_2.equipWeapon(weapon_4);

        assert Battle.fight(unit_1, unit_2) == true;
    }

    @Test
    @DisplayName("5. Weapon")
    void Weapon5() {
        var army_1 = new Army();
        var army_2 = new Army();

        var weapon_1 = IWeapon.newSword();
        var weapon_2 = IWeapon.newGreatAxe();


        army_1.addUnits(() -> new UnitInArmy(IWarrior.newDefender()), 1);
        army_1.addUnits(() -> new UnitInArmy(IWarrior.newWarrior()), 1);
        army_1.setWeaponToLastUnits(weapon_2, 2);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newKnight()), 1);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newHealer()), 1);
        army_2.setWeaponToLastUnits(weapon_1, 2);

        assert Battle.fight(army_1, army_2) == true;
    }

    @Test
    @DisplayName("6. Weapon")
    void Weapon6() {
        var army_1 = new Army();
        var army_2 = new Army();

        var weapon_1 = IWeapon.newKatana();
        var weapon_2 = IWeapon.newShield();

        army_1.addUnits(() -> new UnitInArmy(IWarrior.newDefender()), 2);
        army_1.setWeaponToLastUnits(weapon_1, 2);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newKnight()), 1);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newVampire()), 1);
        army_2.setWeaponToLastUnits(weapon_2, 2);

        assert Battle.fight(army_1, army_2) == true;
    }

    @Test
    @DisplayName("7. Weapon")
    void Weapon7() {
        var army_1 = new Army();
        var army_2 = new Army();

        var weapon_1 = IWeapon.newShield();
        var weapon_2 = IWeapon.newSuperTool();

        army_1.addUnits(() -> new UnitInArmy(IWarrior.newWarrior()), 5);
        army_1.setWeaponToLastUnits(weapon_1, 2);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newWarrior()), 2);
        army_2.setWeaponToLastUnits(weapon_2, 1);

        assert Battle.fight(army_1, army_2) == false;
    }

    @Test
    @DisplayName("8. Weapon")
    void Weapon8() {
        var army_1 = new Army();
        var army_2 = new Army();

        var weapon_1 = IWeapon.newSuperTool();
        var weapon_2 = IWeapon.newSuperTool();

        army_1.addUnits(() -> new UnitInArmy(IWarrior.newDefender()), 10);
        army_1.setWeaponToLastUnits(weapon_1, 5);
        army_2.addUnits(() -> new UnitInArmy(IWarrior.newVampire()), 10);
        army_2.setWeaponToLastUnits(weapon_2, 5);

        assert Battle.fight(army_1, army_2) == false;
    }


}