package codingdojo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {

    // choose this one if you are familiar with mocks
    @Disabled("Test is not finished yet")
    @Test
    void damageCalculationsWithMocks() {
        Equipment equipment = mock(Equipment.class);
        Stats stats = mock(Stats.class);
        when(stats.getModifiedStrength()).thenReturn(0.1f);
        SimpleEnemy target = mock(SimpleEnemy.class);

        Damage damage = new Player(stats, equipment).calculateDamage(target);
        assertEquals(10, damage.getAmount());
    }

    @Test
    void damageFromEquipmentShouldBe10() {
        Equipment equipment = mock(Equipment.class);
        Stats stats = mock(Stats.class);
        when(stats.getModifiedStrength()).thenReturn(0.1f);
        when(equipment.getBaseDamage()).thenReturn(10);

        int baseDamage = new Player(stats, equipment).getBaseDamage();
        assertEquals(10, baseDamage);
    }

    @Test
    void damageModifierFromEquipmentShouldBeX() {
        Equipment equipment = mock(Equipment.class);
        Stats stats = mock(Stats.class);
        when(stats.getModifiedStrength()).thenReturn(0.1f);
        when(equipment.getDamageModifier()).thenReturn(5.1f);

        float strengthModifier = stats.getModifiedStrength();
        float damageModifier = new Player(stats, equipment).getDamageModifier();
        assertEquals(5.1f + strengthModifier, damageModifier);
    }

    @Test
    void totalDamageShouldBeX() {
        Equipment equipment = mock(Equipment.class);
        Stats stats = mock(Stats.class);

        when(stats.getModifiedStrength()).thenReturn(0.1f);
        when(equipment.getDamageModifier()).thenReturn(5.1f);
        when(equipment.getBaseDamage()).thenReturn(10);

        int totalDamage = new Player(stats, equipment).getTotalDamage();
        assertEquals(52, totalDamage);
    }


}
