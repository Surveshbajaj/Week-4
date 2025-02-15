package junittesting;


import static org.junit.jupiter.api.Assertions.*;

import com.junit.basicjunittest.DatabaseConnection;
import org.junit.jupiter.api.*;

class DatabaseConnectionTest {
    private DatabaseConnection dbConnection;

    @BeforeEach
    void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();
    }

    @AfterEach
    void tearDown() {
        dbConnection.disconnect();
    }

    @Test
    void testConnectionEstablished() {
        assertTrue(dbConnection.isConnected(), "Database should be connected before test.");
    }

    @Test
    void testConnectionClosed() {
        dbConnection.disconnect();
        assertFalse(dbConnection.isConnected(), "Database should be disconnected after test.");
    }
}
