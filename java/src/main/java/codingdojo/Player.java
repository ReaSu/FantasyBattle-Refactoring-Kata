package codingdojo;


class Player extends Target {
    private final Equipment equipment;
    private Stats stats;

    Player(Stats stats, Equipment equipment) {
        this.equipment = equipment;
        this.stats = stats;
    }

    Damage calculateDamage(Target other) {
        int baseDamage = getBaseDamage();
        float damageModifier = getDamageModifier();
        int totalDamage = Math.round(baseDamage * damageModifier);
        int soak = getSoak(other, totalDamage);
        return new Damage(Math.max(0, totalDamage - soak));
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
        float strengthModifier = stats.getStrength() * 0.1f;
        return strengthModifier + equipment.getDamageModifier();
    }

    public int getBaseDamage() {
        return equipment.getBaseDamage();
    }
}
