package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
    private WebDriver driver;

    @FindBy(name = "userName")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submit;

    public void login(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        submit.click();
    }

    /*
     * public HomePage(WebDriver driver) { System.out.println("Constructir driver:"
     * +driver); this.driver = driver; PageFactory.initElements(driver, this); }
     */

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
