package junittesting;

import com.junit.basicjunittest.PerformanceTimeout;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

public class PerformanceTimeoutTest {

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS) // Fail if execution exceeds 2 seconds
    void testLongRunningTask() throws InterruptedException {
        assertEquals("Task Completed", PerformanceTimeout.longRunningTask());
    }
}
