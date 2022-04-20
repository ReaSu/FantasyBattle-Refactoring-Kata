package codingdojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {
    @Test
    void damageCalculationsWithMocks() {
        Equipment equipment = mock(Equipment.class);
        Stats stats = mock(Stats.class);
        SimpleEnemy target = mock(SimpleEnemy.class);
        int strength = 1;
        float modifiedStrength = 0.1f;
        when(stats.getModifiedStrength()).thenReturn(0.1f);
        when(equipment.getBaseDamage()).thenReturn(10);
        when(equipment.getDamageModifier(modifiedStrength)).thenReturn(6.1f);
        when(equipment.getTotalDamage(modifiedStrength)).thenReturn(61);
        when(target.getSoak()).thenReturn(2);

        Damage damage = new Player(equipment, strength).calculateDamage(target);
        assertEquals(59, damage.getAmount());
    }

}
