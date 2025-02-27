package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Objects;

public class AccountCreatePage {
    private final WebDriver driver;
    String name;
    String type;
    int balance=0;
    private By homepageBy = By.linkText("https://ac49-2a06-c701-497e-fb00-f902-1d42-f6fb-f91a.ngrok-free.app");
    private By nameInputBy = By.id("ffInput_name");
    private By accountNumberBy = By.name("account_number");
    private By openingBalanceBy = By.name("opening_balance");
    private By openingBalanceDateBy = By.name("opening_balance_date");
    private By submitButtonBy = By.className("btn-success");
    private By successMessageBy = By.className("alert-success");
    AccountCreatePage(WebDriver driver, String type){
        this.driver =driver;
        this.type = type;
    }

    public HomePage homePage(){
        driver.findElement(homepageBy).click();
        return new HomePage(driver);
    }

    public HomePage createAccount(String name,String accountNumber,String balance,String BalanceDate) throws InterruptedException {
        Thread.sleep(1000);
        if (Objects.equals(this.type, "asset")){

            driver.findElement(nameInputBy).click();
            driver.findElement(nameInputBy).clear();
            driver.findElement(nameInputBy).sendKeys(name);
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
            driver.findElement(accountNumberBy).click();
            driver.findElement(accountNumberBy).clear();
            driver.findElement(accountNumberBy).sendKeys(accountNumber);
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
            driver.findElement(openingBalanceBy).click();
            driver.findElement(openingBalanceBy).clear();
            driver.findElement(openingBalanceBy).sendKeys(balance);
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
            driver.findElement(openingBalanceDateBy).click();
            driver.findElement(openingBalanceDateBy).clear();
            driver.findElement(openingBalanceDateBy).sendKeys(BalanceDate);
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
            driver.findElement(submitButtonBy).click();
        }else{
            driver.findElement(nameInputBy).click();
            driver.findElement(nameInputBy).clear();
            driver.findElement(nameInputBy).sendKeys(name);
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
            driver.findElement(submitButtonBy).click();
        }
        return new HomePage(driver);
    }

    public boolean accountCreated(String name){
        return driver.findElement(successMessageBy).getText().equals(" new account "+"\""+name+"\""+" stored! ");
    }




}
