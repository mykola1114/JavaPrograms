package org.example.characters;

public class Vampire extends UnitInArmy implements HasVampirism {
        private int vampirism;

        public Vampire(IWarrior warrior, int vampirism){
                super(warrior);
                this.vampirism = vampirism;
        }

        public void boostVampirism(int value){
                this.vampirism += value;
        }
        @Override
        public int getVampirism() {
        return Math.max(0, vampirism);
        }
        @Override
        public void hit(CanReceiveDamage w) {
                var healthBefore = w.getHealth();
                super.hit(w);
                var healthAfter = w.getHealth();
                var dealtDamage = Math.max(0, healthBefore-healthAfter);
                int selfHealing = dealtDamage * getVampirism() / 100;
                var warrior = (IWarrior) getKernel();
                warrior.healby(selfHealing);
        }

}
