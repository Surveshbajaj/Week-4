package mutiplecatchblocktest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import com.multiplecatchblocks.MultipleCatchBlocks;

public class MutipleCatchBlockTest {


    @Test
    void testValidIndex() {
        int[] arr = {10, 20, 30, 40, 50};
        assertDoesNotThrow(() -> MultipleCatchBlocks.printValueOfArray(arr, 2)); // Should not throw an exception
    }

    @Test
    void testInvalidIndex() {
        int[] arr = {10, 20, 30, 40, 50};
        assertDoesNotThrow(() -> MultipleCatchBlocks.printValueOfArray(arr, 10)); // Should handle out-of-bounds
    }

    @Test
    void testNullArray() {
        int[] arr = null;
        assertDoesNotThrow(() -> MultipleCatchBlocks.printValueOfArray(arr, 1)); // Should handle null array
    }
}
