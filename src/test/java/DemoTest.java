import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest {

    @Test
    @Description("Sample test that always passes")
    public void testPass() {
        Allure.step("This is a testPass in the test");
        step("Assert true is true");
        Assert.assertTrue(true);
    }

    @Step("{0}")
    public void step(String message) {
        Allure.step("This is a step in the test");
        System.out.println(message);
    }
}