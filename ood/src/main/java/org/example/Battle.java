package org.example;

import org.example.characters.HasAbilityToTreat;
import org.example.characters.UnitInArmy;

public class Battle {
    public static boolean fight(UnitInArmy w1, UnitInArmy w2) {
        while (w1.isAlive() && w2.isAlive()) {
            w1.hit(w2);
            if (w2.isAlive()) w2.hit(w1);
        }
        return w1.isAlive();
    }
    public static boolean fight(Army army1, Army army2) {
        var it1 = army1.firstAliveIterator();
        var it2 = army2.firstAliveIterator();

        while (it1.hasNext() && it2.hasNext()) {
            fight(it1.next(), it2.next());
        }
        return it1.hasNext();
    }

    public static boolean straightFight(Army army1, Army army2) {
        army1.restack();
        army2.restack();
        var it1 = army1.nextAliveIterator();
        var it2 = army2.nextAliveIterator();

        while (it1.hasNext() && it2.hasNext()) {
            fight(it1.next(), it2.next());
        }
        return it1.hasNext();
    }
}
