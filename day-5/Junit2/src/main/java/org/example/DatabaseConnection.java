package org.example;

public class DatabaseConnection {
    private boolean isConnected = false;

    public void connect() {
        System.out.println("Connecting to the database...");
        isConnected = true;
    }

    public void disconnect() {
        System.out.println("Disconnecting from the database...");
        isConnected = false;
    }

    public boolean isConnected() {
        return isConnected;
    }
}