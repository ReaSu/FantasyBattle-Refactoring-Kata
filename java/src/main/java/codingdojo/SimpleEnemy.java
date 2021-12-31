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

    List<Buff> getBuffs() {
        return buffs;
    }

    Armor getArmor() {
        return this.armor;
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
    int getFullSoak() {
        return Math.round(getDamageSoak() * getModifiedBuffs());
    }
}
