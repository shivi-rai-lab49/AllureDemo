import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.example.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureTestNg.class})
public class DemoTest extends TestBase {

    @Test
    @Description("Sample test that always passes")
    public void testPass() {
        Allure.step("This is a testPass in the test");
        step("Assert true is true");
        Assert.assertTrue(true);
    }

    @Step("{0}")
    public void step(String message) {
        System.out.println(message);
    }

    @Test
    @Description("Test for login with correct credentials")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Login Feature")
    @Story("As a user, I want to login with valid credentials successfully.")
    public void testLoginWithValidCredentials() {
        // Simulating steps for logging in
        step("Go to the login page");
        step("Enter username and password");
        step("Click login button");

        // Simulated check for successful login
        boolean loginSuccess = true;  // Imagine this comes from actual login logic
        Assert.assertTrue(loginSuccess, "Login should succeed with valid credentials");

        Allure.step("Login test passed successfully.");
    }
    @Test
    @Description("Test for login with wrong credentials (failure case)")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Login Feature")
    @Story("As a user, I want to login with invalid credentials successfully.")
    public void testLoginWithInvalidCredentials() {
        // Simulating steps for logging in
        step("Go to the login page");
        step("Enter invalid username and password");
        step("Click login button");

        // Simulated check for failed login
        boolean loginSuccess = false;  // Imagine this comes from actual login logic
        Assert.assertFalse(loginSuccess, "Login should fail with wrong credentials");

        Allure.step("Login test failed due to invalid credentials.");
    }
    @Test
    @Description("Test for login with no password entered")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Login Feature")
    @Story("As a user, I want to login without password successfully.")
    public void testLoginWithNoPassword() {
        // Simulating steps for logging in with no password
        step("Go to the login page");
        step("Enter username but leave password blank");
        step("Click login button");

        // Simulate check for error due to missing password
        boolean isPasswordEmpty = true;  // Just assuming we are testing empty password
        Assert.assertTrue(isPasswordEmpty, "Password should not be empty");

        Allure.step("Login failed due to missing password.");
    }

    @Test
    @Description("Test with multiple users trying to log in with different credentials")
    @Severity(SeverityLevel.MINOR)
    @Feature("Login Feature")
    @Story("As a user, I want to login with multiple users successfully.")
    public void testLoginWithMultipleUsers() {
        // A simple simulation of multiple users logging in
        String[][] users = {
                {"validUser", "validPassword", "Login successful"},
                {"invalidUser", "wrongPassword", "Login failed"}
        };

        for (String[] user : users) {
            String username = user[0];
            String password = user[1];
            String expectedMessage = user[2];

            step("Trying to login with username: " + username + " and password: " + password);
            boolean loginResult = login(username, password);

            // Check if login result matches the expected message
            if (loginResult) {
                Assert.assertEquals(expectedMessage, "Login successful");
            } else {
                Assert.assertEquals(expectedMessage, "Login failed");
            }
        }
    }
    // Simulated login method for testing
    public boolean login(String username, String password) {
        // Just a simple check for demonstration purposes
        return "validUser".equals(username) && "validPassword".equals(password);
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot();
        }
        // Ensure that WebDriver session is properly closed after all actions are done
        if (driver != null) {
            driver.quit();
        }
    }
    @Attachment(value= "Web Page screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}