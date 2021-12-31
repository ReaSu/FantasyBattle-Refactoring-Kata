package codingdojo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {

    // choose this one if you are familiar with mocks
    @Disabled("Test is not finished yet")
    @Test
    void damageCalculationsWithMocks() {
        Inventory inventory = mock(Inventory.class);
        Equipment equipment = mock(Equipment.class);
        Stats stats = mock(Stats.class);
        SimpleEnemy target = mock(SimpleEnemy.class);

        Damage damage = new Player(stats, equipment).calculateDamage(target);
        assertEquals(10, damage.getAmount());
    }

    @Test
    void damageFromEquipmentShouldBe10() {
        Inventory inventory = mock(Inventory.class);
        Equipment equipment = mock(Equipment.class);
        Stats stats = mock(Stats.class);
        Item leftHand = mock(Item.class);
        Item rightHand = mock(Item.class);
        Item head = mock(Item.class);
        Item feet = mock(Item.class);
        Item chest = mock(Item.class);
        when(leftHand.getBaseDamage()).thenReturn(0);
        when(rightHand.getBaseDamage()).thenReturn(10);
        when(head.getBaseDamage()).thenReturn(0);
        when(feet.getBaseDamage()).thenReturn(0);
        when(chest.getBaseDamage()).thenReturn(0);
        when(equipment.getBaseDamage()).thenReturn(10);

        int baseDamage = new Player(stats, equipment).getBaseDamage();
        assertEquals(10, baseDamage);
    }
    @Test
    void damageModifierFromEquipmentShouldBeX() {
        Inventory inventory = mock(Inventory.class);
        Equipment equipment = mock(Equipment.class);
        Stats stats = mock(Stats.class);
        Item leftHand = mock(Item.class);
        Item rightHand = mock(Item.class);
        Item head = mock(Item.class);
        Item feet = mock(Item.class);
        Item chest = mock(Item.class);
        when(equipment.getLeftHand()).thenReturn(leftHand);
        when(equipment.getRightHand()).thenReturn(rightHand);
        when(equipment.getHead()).thenReturn(head);
        when(equipment.getFeet()).thenReturn(feet);
        when(equipment.getChest()).thenReturn(chest);
        when(leftHand.getDamageModifier()).thenReturn(1.4f);
        when(rightHand.getDamageModifier()).thenReturn(1.0f);
        when(head.getDamageModifier()).thenReturn(1.2f);
        when(feet.getDamageModifier()).thenReturn(0.1f);
        when(chest.getDamageModifier()).thenReturn(1.4f);
        when(stats.getStrength()).thenReturn(1);
        when(equipment.getDamageModifier()).thenReturn(5.1f);

        float strengthModifier = stats.getStrength() * 0.1f;
        float damageModifier = new Player(stats, equipment).getDamageModifier();
        assertEquals(5.1f + strengthModifier, damageModifier);
    }
}
