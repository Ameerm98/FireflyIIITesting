package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BillCreate {
    private final WebDriver driver;
    private By nameInputBy = By.id("ffInput_name");
    private By amountMinBy = By.name("amount_min");
    private By amountMaxBy = By.name("amount_max");
    private By billStartDateBy = By.id("ffInput_date");
    private By billEndDateBy = By.name("bill_end_date");
    private By submitButtonBy = By.className("btn-success");
    private By successMessageBy = By.className("alert-success");



    BillCreate(WebDriver driver){
        this.driver = driver;
    }

    public BillCreate createBill(String name,String minAmount,String maxAmount,String startDate,String endDate){
        driver.findElement(nameInputBy).click();
        driver.findElement(nameInputBy).sendKeys(name);
        driver.findElement(amountMinBy).click();
        driver.findElement(amountMinBy).sendKeys(minAmount);
        driver.findElement(amountMaxBy).click();
        driver.findElement(amountMaxBy).sendKeys(maxAmount);
        driver.findElement(billStartDateBy).click();
        driver.findElement(billStartDateBy).sendKeys(startDate);
        if (endDate!=null){
            driver.findElement(billEndDateBy).click();
            driver.findElement(billEndDateBy).sendKeys(endDate);
        }
        driver.findElement(submitButtonBy).click();
        return new BillCreate(driver);
    }

    public boolean billCreated(String name){
        return driver.findElement(successMessageBy).getText().equals(" Stored new bill "+"\""+name+"\""+" ");
    }
}
