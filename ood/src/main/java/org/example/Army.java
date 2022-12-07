package org.example;

import org.example.characters.UnitInArmy;
import org.example.weapons.IWeapon;

import java.util.*;
import java.util.function.Supplier;

public class Army {
    private Collection<UnitInArmy> troops = new ArrayList<>();
    private UnitInArmy last;

    public void restack() {
        Iterator<UnitInArmy> jj = troops.iterator();
        while (jj.hasNext()){
            var w = jj.next();
            w.setWarriorBehind(null);
        }
    }
    public void setWeaponToLastUnits(IWeapon weapon, int number){
        Iterator<UnitInArmy> y = troops.iterator();
        for (int i = 0; i < troops.size(); i++){
            var x = y.next();
            if (i >= troops.size() - number){
                x.equipWeapon(weapon);
            }
        }
    }

    public Iterator<UnitInArmy> nextAliveIterator(){
        return new NextAliveIterator();
    }
    private class NextAliveIterator implements Iterator<UnitInArmy>{
        private Iterator<UnitInArmy> it = troops.iterator();
        private UnitInArmy champion;
        private UnitInArmy small_champion;
        private Iterator<UnitInArmy> curr;

        private boolean HasAnyUnit(){
            Iterator<UnitInArmy> sit = troops.iterator();

            while (sit.hasNext()){
                small_champion = sit.next();
                curr = sit;
                if (small_champion.isAlive()) return true;
            }
            return false;
        }

        @Override
        public boolean hasNext(){
            if (HasAnyUnit()){
                while (it.hasNext()) {
                    champion = it.next();
                    if (champion.isAlive()) return true;
                }
                it = curr;
                champion = small_champion;
                return true;
            }
            return false;
        }
        @Override
        public UnitInArmy next(){
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return champion;
        }
    }

    public Iterator<UnitInArmy> firstAliveIterator() {
        return new FirstAliveIterator();
    }
    private class FirstAliveIterator implements Iterator<UnitInArmy>{
        private Iterator<UnitInArmy> it = troops.iterator();
        private UnitInArmy champion;

        @Override
        public boolean hasNext(){
            if (champion != null && champion.isAlive()) {
                return true;
            }
            while (it.hasNext()) {
                champion = it.next();
                if (champion.isAlive()) return true;
            }
            return false;
        }
        @Override
        public UnitInArmy next(){
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return champion;
        }
    }
    public Army addUnits(UnitInArmy warrior){
        if (last != null) {
            last.setWarriorBehind(warrior);
        }
        troops.add(warrior);
        last = warrior;
        return this;
    }
    public Army addUnits(Supplier<UnitInArmy> factory, int quantity) {
        for(int i=0; i<quantity;i++){
            addUnits(factory.get());
        }
        return this;
    }

}
