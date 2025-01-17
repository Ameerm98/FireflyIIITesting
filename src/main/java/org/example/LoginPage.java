package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.time.Duration;


public class LoginPage extends LoadableComponent {

    private final String baseURL = "https://a05c-2a06-c701-9ca4-ad00-9cc3-5696-30ab-de32.ngrok-free.app";
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
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get(baseURL+"/login");
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
