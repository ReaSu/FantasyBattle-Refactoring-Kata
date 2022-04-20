package codingdojo;

import java.util.Arrays;
import java.util.List;

class Equipment {
    // TODO add a ring item that may be equipped
    //  that may also add damage modifier

    private final List<Item> fullEquipment;

    Equipment(Item leftHand, Item rightHand, Item head, Item feet, Item chest) {
        fullEquipment = Arrays.asList(leftHand, rightHand, head, feet, chest);
    }


    int getBaseDamage() {
        return fullEquipment.stream().mapToInt(Item::getBaseDamage).sum();
    }


    float getDamageModifier(float modifiedStrength) {
        return (float) fullEquipment.stream().mapToDouble(Item::getDamageModifier).sum()
               + modifiedStrength;
    }

    int getTotalDamage(float modifiedStrength) {
        return Math.round(getBaseDamage() * getDamageModifier(modifiedStrength));
    }

}
