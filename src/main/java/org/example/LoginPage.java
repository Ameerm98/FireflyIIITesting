package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage extends LoadableComponent {

    private final String baseURL = "https://7c5a-2a06-c701-497e-fb00-f902-1d42-f6fb-f91a.ngrok-free.app";
    private WebDriver driver;
    private By emailFieldBy = By.name("email");
    private By passwordFieldBy = By.name("password");
    private By signInButtonBy = By.cssSelector("button[type='submit']");
    private By resetPasswordButtonBy = By.cssSelector("a[href='"+baseURL+"/password/reset']");
    private By credentialsMessageBy = By.cssSelector(".alert-danger ul li");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @Override
    protected void load(){
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.get(baseURL+"/login");
        try {
            Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement visitSiteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Visit Site']")));
            visitSiteButton.click();
        } catch (TimeoutException err) {
            System.out.println("Ngrok warning page was not loaded");
        }

    }
    @Override
    protected void isLoaded() throws Error {
        assert(driver.getTitle().contains("Login"));
    }

    public HomePage loginAsValidUser(String userName, String password) {
        driver.findElement(emailFieldBy).sendKeys(userName);
        driver.findElement(passwordFieldBy).sendKeys(password);
        driver.findElement(signInButtonBy).click();

        return new HomePage(driver);
    }

    public LoginPage loginAsInvalidUser(String userName, String password){
        driver.findElement(emailFieldBy).sendKeys(userName);
        driver.findElement(passwordFieldBy).sendKeys(password);
        driver.findElement(signInButtonBy).click();

        return new LoginPage(driver);
    }
    public ResetPasswordPage resetPassword(){
        driver.findElement(resetPasswordButtonBy).click();
        return new ResetPasswordPage(driver);

    }
    public String getTitle(){
        String title = driver.getTitle();
        return title;
    }
    public String invalidCredentialsMessage(){
        return driver.findElement(credentialsMessageBy).getText();
    }



}
