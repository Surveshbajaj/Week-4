package junittesting;

import static org.junit.jupiter.api.Assertions.*;

import com.junit.basicjunittest.ListManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class ListManagerTest {

    List<Integer> list = new ArrayList<>();

    @BeforeEach
    void setUp() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }

    @Test
    void testInitialListState() {
        assertEquals(4, ListManager.getSize(list));
        assertEquals(List.of(1, 2, 3, 4), list);
    }

    @Test
    void testAddElement() {
        ListManager .addElement(list);
        assertEquals(5, ListManager .getSize(list));
        assertEquals(5, list.get(4)); // Check if 5 was added at the correct index
    }

    @Test
    void testRemoveElement() {
        ListManager .addElement(list); // First, add 5 to match main method behavior
        ListManager .removeElement(list);
        assertEquals(4, ListManager .getSize(list)); // Size should be back to 4
        assertFalse(list.contains(5)); // 5 should be removed
    }

    @Test
    void testRemoveFromSmallList() {
        list.remove(3); // Removing index 3 to make the list smaller
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> ListManager .removeElement(list));
        assertEquals("Index 4 out of bounds for length 3", exception.getMessage());
    }
}
