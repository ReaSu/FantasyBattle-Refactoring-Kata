package codingdojo;

public class Stats {
    // TODO add dexterity that will both help with soak and damage.
    //  but half of what strength gives.
    private int strength;
    private static float MODIFIER = 0.1f;

    public Stats(int strength) {
        this.strength = strength;
    }

    int getStrength() {
        return strength;
    }

    float getModifiedStrength() {
        return strength * MODIFIER;
    }
}
