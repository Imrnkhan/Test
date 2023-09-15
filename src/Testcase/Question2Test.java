//package Testcase;
//
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//class MobileOrderingAppTest {
//    private MobileOrderingApp app;
//
//    @BeforeEach
//    void setUp() {
//        app = new MobileOrderingApp();
//    }
//
//    @Test
//    void testValidSignup() {
//        assertTrue(app.signup("John Doe", "0123456789", "01/01/1990", "Password1"));
//        assertEquals(1, app.getUsers().size());
//    }
//
//    @Test
//    void testInvalidSignup() {
//        assertFalse(app.signup("Invalid User", "1234", "01/01/2000", "12345"));
//        assertEquals(0, app.getUsers().size());
//    }
//
//    @Test
//    void testLogin() {
//        app.signup("John Doe", "0123456789", "01/01/1990", "Password1");
//        app.signup("Alice Smith", "9876543210", "01/01/1985", "Secret123");
//
//        assertNull(app.getLoggedInUser());
//
//        app.login("0123456789", "Password1");
//        assertNotNull(app.getLoggedInUser());
//        assertEquals("John Doe", app.getLoggedInUser().getFullName());
//
//        app.logout();
//        assertNull(app.getLoggedInUser());
//    }
//}
