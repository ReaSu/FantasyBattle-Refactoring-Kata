package codingdojo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EnemyTest {

    private List<Buff> buffList;
    private Armor armor;

    @BeforeEach
    void setUp() {
        Buff buff = mock(Buff.class);
        buffList = Collections.singletonList(buff);
        armor = mock(Armor.class);
        when(buff.soakModifier()).thenReturn(1f);
        when(armor.getDamageSoak()).thenReturn(1);
    }

    @Test
    public void buffsShouldBeX() {
        float buffs = new SimpleEnemy(armor, buffList).getTotalBuffs();
        assertEquals(1f, buffs);
    }

    @Test
    public void modifiedBuffsShouldBe2f() {
        float modifiedBuffs = new SimpleEnemy(armor, buffList).getModifiedBuffs();
        assertEquals(2f, modifiedBuffs);
    }

    @Test
    public void enemyDamageSoakShouldBe1() {
        int damageSoak = new SimpleEnemy(armor, buffList).getDamageSoak();
        assertEquals(1, damageSoak);
    }

    @Test
    void fullDamageSoakShouldBeX() {
        int fullDamageSoak = new SimpleEnemy(armor, buffList).getSoak();
        assertEquals(2, fullDamageSoak);
    }
}
