package edu.bsu.testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UtilTest {

    @Test
    public void max_EmptyValues_test() {
        assertThrows(IllegalArgumentException.class,
                Util::max, "IllegalArgumentException is expected");
    }

    @Test
    public void max_ThreeDifferentValues_test() {
        int max = Util.max(0, 5, -4);
        assertEquals(5, max);
    }

    @Test
    public void max_AllSameValues_test() {
        int max = Util.max(1, 1, 1);
        assertEquals(1, max);
    }

    @Test
    public void max_FiveDifferentNegativeValues_test() {
        int max = Util.max(-3, -7, -1, -5, -10);
        assertEquals(-1, max);
    }
}
