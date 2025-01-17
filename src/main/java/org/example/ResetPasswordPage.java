package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPasswordPage {
    private WebDriver driver;
    private By emailFieldBy = By.name("email");
    private By resetButtonBy = By.cssSelector("button[type='submit']");
    private By textSuccessBy = By.className("text-success");


    ResetPasswordPage(WebDriver driver){
        this.driver = driver;
    }
    public String reset(String email){
        driver.findElement(emailFieldBy).sendKeys(email);
        driver.findElement(resetButtonBy).click();
        return driver.findElement(textSuccessBy).getText();
    }



}
