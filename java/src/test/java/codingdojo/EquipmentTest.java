package codingdojo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EquipmentTest {

    private BasicItem leftHand;
    private BasicItem rightHand;
    private BasicItem head;
    private BasicItem feet;
    private BasicItem chest;

    @BeforeEach
    void setUp() {
        this.leftHand = mock(BasicItem.class);
        this.rightHand = mock(BasicItem.class);
        this.head = mock(BasicItem.class);
        this.feet = mock(BasicItem.class);
        this.chest = mock(BasicItem.class);
        when(rightHand.getBaseDamage()).thenReturn(10);
        when(leftHand.getDamageModifier()).thenReturn(1.4f);
        when(rightHand.getDamageModifier()).thenReturn(1.0f);
        when(head.getDamageModifier()).thenReturn(1.2f);
        when(feet.getDamageModifier()).thenReturn(0.1f);
        when(chest.getDamageModifier()).thenReturn(1.4f);
    }

    @Test
    void getBaseDamage() {
        Equipment equipment = new Equipment(leftHand, rightHand, head, feet, chest);
        int baseDamage = equipment.getBaseDamage();
        assertEquals(10, baseDamage);
    }

    @Test
    void getDamageModifier() {
        Equipment equipment = new Equipment(leftHand, rightHand, head, feet, chest);
        float modifiedStrength = 1;
        float damageModifier = equipment.getDamageModifier(modifiedStrength);
        assertEquals(6.1f, damageModifier);
    }

    @Test
    void getTotalDamage() {
        int modifiedStrength = 1;
        Equipment equipment = new Equipment(leftHand, rightHand, head, feet, chest);
        int totalDamage = equipment.getTotalDamage(modifiedStrength);
        assertEquals(61, totalDamage);
    }
}