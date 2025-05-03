import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.example.HomePage;
import org.example.TestBase;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

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
    @Step("1. Launch URL. 2. Click on Login button 3. Enter username and password. 4. Click on submit button and verify user gets logged in successfully.")
    public void login() {
        hp.login("admin", "admin");
    }

    @Test(priority=2, description = "TestNG description 2" )
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify fail scenario")
    @Step("1. Just to showcase fail scenario")
    public void fail() {
        boolean flag=false;
        Assert.assertFalse(flag);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(); // Only on failure
        }
        driver.quit();
    }

    @Attachment(value= "Web Page screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
