package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTestTest {

    private final PerformanceTest performanceTest = new PerformanceTest();

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS) // Specify timeout of 2 seconds
    void testLongRunningTask_withinTimeout() {
        String result = performanceTest.longRunningTask(1); // Task takes 1 second
        assertEquals("Task completed", result);
    }

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testLongRunningTask_exceedsTimeout() {
        performanceTest.longRunningTask(3);
    }

    @Test
    @Timeout(value = 3500, unit = TimeUnit.MILLISECONDS)
    void testLongRunningTask_withMilliseconds() {
        String result = performanceTest.longRunningTask(3);
        assertEquals("Task completed", result);
    }
}