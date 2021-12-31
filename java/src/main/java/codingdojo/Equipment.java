package codingdojo;

import java.util.Arrays;
import java.util.List;

class Equipment {
    // TODO add a ring item that may be equipped
    //  that may also add damage modifier
    private Item leftHand;
    private Item rightHand;
    private Item head;
    private Item feet;
    private Item chest;
    private List<Item> fullEquipment = Arrays.asList(leftHand, rightHand, head, feet, chest);

    Equipment(Item leftHand, Item rightHand, Item head, Item feet, Item chest) {
        this.leftHand = leftHand;
        this.rightHand = rightHand;
        this.head = head;
        this.feet = feet;
        this.chest = chest;
    }



    int getBaseDamage() {
        return fullEquipment.stream().mapToInt(Item::getBaseDamage).sum();
    }


    float getDamageModifier() {
        return (float) fullEquipment.stream().mapToDouble(Item::getDamageModifier).sum();
    }


    Item getLeftHand() {
        return leftHand;
    }

    Item getRightHand() {
        return rightHand;
    }

    Item getHead() {
        return head;
    }

    Item getFeet() {
        return feet;
    }

    Item getChest() {
        return chest;
    }
}
