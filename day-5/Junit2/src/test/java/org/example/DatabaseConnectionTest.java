package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {
    private DatabaseConnection dbc;

    @BeforeEach
    void connect() {
        dbc = new DatabaseConnection();
        dbc.connect();
    }

    @AfterEach
    void disconnect() {
        dbc.disconnect();
    }

    @Test
    void isConnected() {
        assertTrue(dbc.isConnected());

    }

    @Test
    void isDisconnected() {
        assertFalse(dbc.isConnected());
    }
}