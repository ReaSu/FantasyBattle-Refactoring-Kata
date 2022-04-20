package codingdojo;


class Player extends Target {
    private final Equipment equipment;
    private final float modifiedStrength;
    private static final float MODIFIER = 0.1f;

    Player(Equipment equipment, int strength) {
        this.equipment = equipment;
        this.modifiedStrength = strength * MODIFIER;
    }

    Damage calculateDamage(Target other) {
        return new Damage(calculatedDamage(other));
    }

    private int calculatedDamage(Target other) {
        return Math.max(0, equipment.getTotalDamage(modifiedStrength) - other.getSoak());
    }

    @Override
    int getSoak() {
        return equipment.getTotalDamage(modifiedStrength);
    }
}
