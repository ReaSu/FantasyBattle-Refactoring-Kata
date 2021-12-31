package codingdojo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EnemyTest {

    @Test
    public void buffsShouldBeX() {
        Buff buff = mock(Buff.class);
        Armor armor = mock(Armor.class);
        List<Buff> buffList = Arrays.asList(buff);
        when(buff.soakModifier()).thenReturn(1f);

        float buffs = new SimpleEnemy(armor, buffList).getTotalBuffs();
        assertEquals(1f, buffs);
    }

    @Test
    public void modifiedBuffsShouldBe2f() {
        Buff buff = mock(Buff.class);
        Armor armor = mock(Armor.class);
        List<Buff> buffList = Arrays.asList(buff);
        when(buff.soakModifier()).thenReturn(1f);

        float modifiedBuffs = new SimpleEnemy(armor, buffList).getModifiedBuffs();
        assertEquals(2f, modifiedBuffs);
    }

    @Test
    public void enemyDamageSoakShouldBe1() {
        Buff buff = mock(Buff.class);
        List<Buff> buffList = Arrays.asList(buff);
        Armor armor = mock(Armor.class);

        when(buff.soakModifier()).thenReturn(1f);
        when(armor.getDamageSoak()).thenReturn(1);

        int damageSoak = new SimpleEnemy(armor, buffList).getDamageSoak();
        assertEquals(1, damageSoak);
    }

    @Test
    void fullDamageSoakShouldBeX() {
        Buff buff = mock(Buff.class);
        List<Buff> buffList = Arrays.asList(buff);
        Armor armor = mock(Armor.class);

        when(buff.soakModifier()).thenReturn(1f);
        when(armor.getDamageSoak()).thenReturn(1);
        when(armor.getDamageSoak()).thenReturn(1);

        int fullDamageSoak = new SimpleEnemy(armor, buffList).getFullSoak();
        assertEquals(2, fullDamageSoak);
    }
}
