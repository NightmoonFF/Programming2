package PRO.Lektion8_Generics.Exercise3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BagTest {

    private Bag<String> bag;

    @BeforeEach
    public void setUp() {

        bag = new ArrayBag<>();
    }

    @Test
    public void testAdd() {
        // act
        boolean isAdded = bag.add("Lis");
        // assert
        Assertions.assertTrue(isAdded);
        assertTrue(bag.contains("Lis"));
        assertEquals(1, bag.getCurrentSize());
    }

    @Test
    public void testAddWhenFull() {
        // arrange
        for (int i = 0; i < 10; i++) {
            bag.add("item" + i);
        }
        // act
        boolean isAdded = bag.add("Per");
        // assert
        Assertions.assertFalse(isAdded);
        assertFalse(bag.contains("Per"));
        assertEquals(10, bag.getCurrentSize());
    }

    @Test
    public void testRemoveRandom() {
        // arrange
        bag.add("Jan");
        bag.add("Per");
        bag.add("Hans");
        // act
        String removed = bag.remove();
        // assert
        Assertions.assertTrue(List.of("Jan", "Per", "Hans").contains(removed));
        assertEquals(2, bag.getCurrentSize());
    }

    @Test
    public void testRemoveRandomWhenEmpty() {
        // act
        String removed = bag.remove();
        // assert
        Assertions.assertNull(removed);
    }

    @Test
    public void testRemoveEntryWhenAdded() {
        // arrange
        bag.add("Jan");
        bag.add("Per");
        bag.add("Hans");
        // act
        boolean isPerRemoved = bag.remove("Per");
        // assert
        Assertions.assertTrue(isPerRemoved);
        assertFalse(bag.contains("Per"));
        assertEquals(2, bag.getCurrentSize());
    }

    @Test
    public void testRemoveEntryWhenNotAdded() {
        // arrange
        bag.add("Jan");
        bag.add("Per");
        bag.add("Hans");
        // act
        boolean isJensRemoved = bag.remove("Jens");
        // assert
        Assertions.assertFalse(isJensRemoved);
        assertEquals(3, bag.getCurrentSize());
    }

    @Test
    public void testClear() {
        // arrange
        bag.add("Jan");
        bag.add("Per");
        bag.add("Hans");
        // act
        bag.clear();
        // assert
        assertTrue(bag.isEmpty());
    }

    @Test
    public void testGetFrequencyOf() {
        // arrange
        bag.add("Jan");
        bag.add("Per");
        bag.add("Hans");
        bag.add("Per");
        // act
        int freqJens = bag.getFrequencyOf("Jens");
        int freqJan = bag.getFrequencyOf("Jan");
        int freqHans = bag.getFrequencyOf("Hans");
        int freqPer = bag.getFrequencyOf("Per");
        // assert
        Assertions.assertEquals(0, freqJens);
        Assertions.assertEquals(1, freqJan);
        Assertions.assertEquals(1, freqHans);
        Assertions.assertEquals(2, freqPer);
    }

    @Test
    public void testContains() {
        // arrange
        bag.add("Jan");
        bag.add("Per");
        // act
        boolean isJensFound = bag.contains("Jens");
        boolean isJanFound = bag.contains("Jan");
        // assert
        Assertions.assertFalse(isJensFound);
        Assertions.assertTrue(isJanFound);
    }

    @Test
    public void testToArray() {
        // arrange
        bag.add("Jan");
        bag.add("Per");
        // act
        Object[] items = bag.toArray();
        // assert
        Assertions.assertTrue(Arrays.asList(items).contains("Jan"));
        Assertions.assertTrue(Arrays.asList(items).contains("Per"));
    }

}
