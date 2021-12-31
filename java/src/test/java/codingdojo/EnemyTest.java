package codingdojo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EnemyTest {

    @Test
    public void modifiedBuffsShouldBe2f() {
        Buff buff = mock(Buff.class);
        List<Buff> buffList = Arrays.asList(buff);
        SimpleEnemy simpleEnemy = mock(SimpleEnemy.class);
        when(buff.soakModifier()).thenReturn(1f);
        when(simpleEnemy.getBuffs()).thenReturn(buffList);
        when(simpleEnemy.getTotalBuffs()).thenReturn(1f);
        when(simpleEnemy.getModifiedBuffs()).thenReturn(2f);

        float modifiedBuffs = simpleEnemy.getModifiedBuffs();
        assertEquals(2f, modifiedBuffs);
    }

    @Test
    public void buffsShouldBeX() {
        Buff buff = mock(Buff.class);
        List<Buff> buffList = Arrays.asList(buff);
        SimpleEnemy simpleEnemy = mock(SimpleEnemy.class);
        when(buff.soakModifier()).thenReturn(1f);
        when(simpleEnemy.getBuffs()).thenReturn(buffList);
        when(simpleEnemy.getTotalBuffs()).thenReturn(1f);

        float buffs = simpleEnemy.getTotalBuffs();
        assertEquals(1f, buffs);
    }

    @Test
    public void enemyDamageSoakShouldBeX() {
        Buff buff = mock(Buff.class);
        List<Buff> buffList = Arrays.asList(buff);
        SimpleEnemy simpleEnemy = mock(SimpleEnemy.class);
        when(buff.soakModifier()).thenReturn(1f);
        when(simpleEnemy.getBuffs()).thenReturn(buffList);
        when(simpleEnemy.getTotalBuffs()).thenReturn(1f);
        when(simpleEnemy.getModifiedBuffs()).thenReturn(2f);

        float modifiedBuffs = simpleEnemy.getModifiedBuffs();
        assertEquals(2f, modifiedBuffs);
    }
}
