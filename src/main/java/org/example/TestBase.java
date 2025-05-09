package org.example;

import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestBase {
    public static WebDriver driver;


    public static void init() {
        String browserName = "chrome";
        System.out.println("browser name is " + browserName);
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.silentOutput", "true");
        System.out.println("Browser is set to chrome");

        driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://demo.guru99.com/test/newtours/");

        } catch (Exception e) {
            e.printStackTrace();
            //System.exit(0);
        }

    }
    // Start video recording before each test
    @BeforeMethod
    public void startVideoRecording(Method method) throws Exception {
        //VideoRecorderUtil.startRecording(method.getName());
    }

    // Stop video recording after each test and attach video to Allure report
    @AfterMethod
    public void stopVideoRecording() throws Exception {
        //VideoRecorderUtil.stopRecording();

        // Check if video exists and attach it
//        File lastVideoFile = VideoRecorderUtil.getLastVideoFile();
//        if (lastVideoFile != null && lastVideoFile.exists()) {
//            attachVideo(lastVideoFile.getAbsolutePath());
//            System.out.println("Video saved at: " + lastVideoFile.getAbsolutePath().replace("avi",".mp4"));
//        } else {
//            System.out.println("Video file not found for attachment.");
//        }
    }

    // Attach video to Allure report
    @Attachment(value = "Test Execution Video", type = "video/mp4")
    public byte[] attachVideo(String filePath) throws Exception {
        File file = new File(filePath);
        if (file.exists()) {
            return Files.readAllBytes(Paths.get(filePath));
        } else {
            System.out.println("Error: Video file does not exist at path: " + filePath);
            return new byte[0]; // Return empty byte array if video doesn't exist
        }
    }


}
