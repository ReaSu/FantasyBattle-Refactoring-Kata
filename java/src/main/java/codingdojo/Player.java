package codingdojo;


class Player extends Target {
    private Inventory inventory;
    private Stats stats;

    Player(Inventory inventory, Stats stats) {
        this.inventory = inventory;
        this.stats = stats;
    }

    Damage calculateFightDamage(Target other) {
        return new Damage(Math.max(0, getEquipDamage() - other.getSoak()));
    }

    @Override
    public int getSoak() {
        return getEquipDamage();
    }

    private int getEquipDamage() {
        return inventory.getEquipment().equipDamage(stats.getStrength());
    }
}
