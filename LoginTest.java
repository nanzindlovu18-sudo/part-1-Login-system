import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class LoginTest {

    @Test
    public void testLoginSuccessful() {
        Login user = new Login(
            "Kyle",
            "Smith",
            "KY1_1",
            "Ch&&sec@ke99!",
            "+27838968976"
        );

        assertTrue(user.loginUser("KY1_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailed() {
        Login user = new Login(
            "Kyle",
            "Smith",
            "KY1_1",
            "Ch&&sec@ke99!",
            "+27838968976"
        );

        assertFalse(user.loginUser("WRONG", "wrongpassword"));
    }

    @Test
    public void testUsernameCorrect() {
        Login user = new Login(
            "Kyle",
            "Smith",
            "KY1_1",
            "Ch&&sec@ke99!",
            "+27838968976"
        );

        assertTrue(user.checkUserName());
    }

    @Test
    public void testUsernameIncorrect() {
        Login user = new Login(
            "Kyle",
            "Smith",
            "KY123456",
            "Ch&&sec@ke99!",
            "+27838968976"
        );

        assertFalse(user.checkUserName());
    }

    @Test
    public void testPasswordCorrect() {
        Login user = new Login(
            "Kyle",
            "Smith",
            "KY1_1",
            "Ch&&sec@ke99!",
            "+27838968976"
        );

        assertTrue(user.checkPasswordComplexity());
    }

    @Test
    public void testPasswordIncorrect() {
        Login user = new Login(
            "Kyle",
            "Smith",
            "KY1_1",
            "password",
            "+27838968976"
        );

        assertFalse(user.checkPasswordComplexity());
    }

    @Test
    public void testCellPhoneCorrect() {
        Login user = new Login(
            "Kyle",
            "Smith",
            "KY1_1",
            "Ch&&sec@ke99!",
            "+27838968976"
        );

        assertTrue(user.checkCellPhoneNumber());
    }

    @Test
    public void testCellPhoneIncorrect() {
        Login user = new Login(
            "Kyle",
            "Smith",
            "KY1_1",
            "Ch&&sec@ke99!",
            "08966553"
        );

        assertFalse(user.checkCellPhoneNumber());
    }
}
