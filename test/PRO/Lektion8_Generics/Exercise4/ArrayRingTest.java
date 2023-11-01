package PRO.Lektion8_Generics.Exercise4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayRingTest {

    static ArrayRing<String> ring;

    @BeforeEach
    void init() {

        ring = new ArrayRing<>();
        ring.add("A");
        ring.add("B");
        ring.add("C");
        ring.add("D");
        ring.add("E");
    }

    @Test
    @DisplayName("ArrayRing Tests")
    void getAdd() {

        ring.add("F");
        assertSame("F", ring.getCurrentItem());
        ring.add("G");
        assertSame("G", ring.getCurrentItem());
        ring.removeCurrentItem();
        assertSame("A", ring.getCurrentItem());
        ring.removeCurrentItem();
        assertSame("B", ring.getCurrentItem());
        ring.add("X");
        assertSame("X", ring.getCurrentItem());
        ring.removeItem("X");
        assertSame("C", ring.getCurrentItem());
        ring.removeItem("B");
        assertSame("C", ring.getCurrentItem());
    }

    @Test
    void advance() {

        assertSame("E", ring.getCurrentItem());
        ring.advance();
        assertSame("A", ring.getCurrentItem());
        ring.advance();
        assertSame("B", ring.getCurrentItem());
        ring.add("X");
        assertSame("X", ring.getCurrentItem());
    }

    @Test
    void size() {

        int actualResult = ring.size();
        assertEquals(5, actualResult);

    }

    @Test
    void isEmpty() {

        ring.clear();
        boolean actualResult = ring.isEmpty();
        assertTrue(actualResult);

    }

}