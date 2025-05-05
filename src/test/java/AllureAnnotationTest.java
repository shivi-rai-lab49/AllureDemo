
import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.example.HomePage;
import org.example.TestBase;

@Listeners({AllureTestNg.class})
public class AllureAnnotationTest extends TestBase{

    static HomePage hp;

    @BeforeMethod
    public void setUp() {
        init();
        hp=new HomePage(driver);
    }

    @Test(priority=1, description = "TestNG description 1")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify login")
    @Feature("Login Feature")
    @Story("As a user, I want to login successfully.")
    @Step("1. Launch URL. 2. Click on Login button 3. Enter username and password. 4. Click on submit button and verify user gets logged in successfully.")
    @Owner("Shivi Rai")
    public void login() {
        Allure.addAttachment("Test Step", "This is a test step attachment");
        hp.login("admin", "admin");
    }

    @Test(priority=2, description = "TestNG description 2" )

    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify fail scenario")
    @Feature("Login Feature")
    @Story("As a user, I want to handle invalid login attempts.")
    @Step("1. Just to showcase fail scenario")
    @Owner("Shivi Rai")  // You can also track test authorship for trends
    public void fail() {
        boolean flag=true;
        Assert.assertFalse(flag);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        // Take screenshot only if the test failed
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenshot();
        }
        if (driver != null) {
            driver.quit();
        }

    }

    @Attachment(value= "Web Page screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
