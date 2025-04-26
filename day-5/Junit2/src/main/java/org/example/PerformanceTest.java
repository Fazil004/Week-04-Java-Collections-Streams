package org.example;

import java.util.concurrent.TimeUnit;

public class PerformanceTest {

    public String longRunningTask(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Task interrupted";
        }
        return "Task completed";
    }
}
