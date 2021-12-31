package codingdojo;


class Player extends Target {
    private final Equipment equipment;
    private final float modifiedStrength;

    Player(Stats stats, Equipment equipment) {
        this.equipment = equipment;
        this.modifiedStrength = stats.getModifiedStrength();
    }

    Damage calculateDamage(Target other) {
        int soak = getSoak(other, getTotalDamage());
        return new Damage(Math.max(0, getTotalDamage() - soak));
    }



    private int getSoak(Target other, int totalDamage) {
        int soak = 0;
        if (other instanceof Player) {
            // TODO: Not implemented yet
            //  Add friendly fire
            soak = totalDamage;
        } else if (other instanceof SimpleEnemy) {
            SimpleEnemy simpleEnemy = (SimpleEnemy) other;
            soak = Math.round(
                simpleEnemy.getArmor().getDamageSoak() *
                (
                    ((float) simpleEnemy.getBuffs()
                        .stream()
                        .mapToDouble(Buff::soakModifier)
                        .sum()) +
                    1f
                )
            );
        }
        return soak;
    }

    public float getDamageModifier() {
        return modifiedStrength + equipment.getDamageModifier();
    }

    public int getBaseDamage() {
        return equipment.getBaseDamage();
    }

    public int getTotalDamage() {
        int baseDamage = getBaseDamage();
        float damageModifier = getDamageModifier();
        return Math.round(baseDamage * damageModifier);
    }
}
