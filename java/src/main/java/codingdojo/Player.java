package codingdojo;


class Player extends Target {
    private final Equipment equipment;
    private final float modifiedStrength;

    Player(Stats stats, Equipment equipment) {
        this.equipment = equipment;
        this.modifiedStrength = stats.getModifiedStrength();
    }

    Damage calculateDamage(Target other) {
        int soak = getSoak(other);
        return new Damage(Math.max(0, getTotalDamage() - soak));
    }



    private int getSoak(Target other) {
        int soak = 0;
        if (other instanceof Player) {
            // TODO: Not implemented yet
            //  Add friendly fire
            soak = getTotalDamage();
        } else if (other instanceof SimpleEnemy) {
            soak = other.getFullSoak();
        }
        return soak;
    }

    float getDamageModifier() {
        return modifiedStrength + equipment.getDamageModifier();
    }

    int getBaseDamage() {
        return equipment.getBaseDamage();
    }

    int getTotalDamage() {
        return Math.round(getBaseDamage() * getDamageModifier());
    }

    @Override
    int getFullSoak() {
        return getTotalDamage();
    }
}
