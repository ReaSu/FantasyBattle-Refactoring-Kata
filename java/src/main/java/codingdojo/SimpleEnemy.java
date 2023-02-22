package codingdojo;

import java.util.List;

public class SimpleEnemy extends Target {

    private Armor armor;
    private List<Buff> buffs;

    public SimpleEnemy(Armor armor, List<Buff> buffs) {
        this.armor = armor;
        this.buffs = buffs;
    }

    List<Buff> getBuffs() {
        return buffs;
    }

    Armor getArmor() {
        return this.armor;
    }

    @Override
    public int getSoak() {
        int soak = Math.round(
            armor.getDamageSoak() *
            (
                ((float) buffs
                    .stream()
                    .mapToDouble(Buff::soakModifier)
                    .sum()) +
                1f
            )
        );
        return soak;
    }
}
