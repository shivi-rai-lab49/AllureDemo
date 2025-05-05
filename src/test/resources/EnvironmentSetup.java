import io.qameta.allure.Allure;
import org.example.TestBase;
import org.testng.annotations.BeforeSuite;

public class EnvironmentSetup {

    @BeforeSuite
    public void setAllureEnvironment() {
        Allure.addEnvironmentInfo("Browser", "Chrome");
        Allure.addEnvironmentInfo("Browser.Version", "136.0.7103.49");
        Allure.addEnvironmentInfo("Environment", "QA");
        Allure.addEnvironmentInfo("Java Version", System.getProperty("java.version"));
        Allure.addEnvironmentInfo("OS", System.getProperty("os.name"));
    }
}
