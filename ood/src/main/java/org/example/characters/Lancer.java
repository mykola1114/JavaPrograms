package org.example.characters;

public class Lancer extends UnitInArmy implements HasPenitration{
    private final int penitration;

    public Lancer(IWarrior warrior, int penitration){
        super(warrior);
        this.penitration = penitration;
    }

    @Override
    public int getPenitration(){
        return penitration;
    }

    @Override
    public void hit(CanReceiveDamage w){
        var healthBefore = w.getHealth();
        super.hit(w);
        var healthAfter = w.getHealth();
        var dealtDamage = Math.max(0, healthBefore-healthAfter);
        var damageForTheNext = dealtDamage * getPenitration() / 100;
        if (w instanceof HasWarriorBehind) {
            var nextOpponent = ((HasWarriorBehind) w).getWarriorBehind();
            if (nextOpponent != null){
                nextOpponent.receiveDamage(damageForTheNext);
            }
        }

    }
}
