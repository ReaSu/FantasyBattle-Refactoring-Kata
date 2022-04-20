package codingdojo;

import java.util.List;

public class SimpleEnemy extends Target {
    public static final float BUFF_MODIFIER = 1f;
    protected Armor armor;
    protected List<Buff> buffs;

    public SimpleEnemy(Armor armor, List<Buff> buffs) {
        this.armor = armor;
        this.buffs = buffs;
    }

    float getTotalBuffs() {
        return (float) buffs
                .stream()
                .mapToDouble(Buff::soakModifier)
                .sum();
    }

    float getModifiedBuffs() {
        return getTotalBuffs() + BUFF_MODIFIER;
    }

    int getDamageSoak() {
        return armor.getDamageSoak();
    }

    @Override
    int getSoak() {
        return Math.round(getDamageSoak() * getModifiedBuffs());
    }
}
