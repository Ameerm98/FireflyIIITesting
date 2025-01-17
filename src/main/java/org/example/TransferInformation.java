package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransferInformation {
    private final WebDriver driver ;
    private final By descriptionBy = By.cssSelector("div:nth-child(1) > div > div.box-body.no-padding > table > tbody > tr:nth-child(2) > td:nth-child(2)");
    private final By dateBy = By.className("date-time");
    private final By sourceAccountBy = By.cssSelector(" table > tbody > tr:nth-child(1) > td:nth-child(2) > a");
    private final By destinationAccountBy = By.cssSelector("table > tbody > tr:nth-child(2) > td:nth-child(2) > a");
    private final By amountBy = By.cssSelector("div:nth-child(2) > div > div.box-body.no-padding > table > tbody > tr:nth-child(3) > td:nth-child(2) > span");
    private final By categoryBy = By.cssSelector("div:nth-child(4) > div > div > div.box-body.no-padding > table > tbody > tr:nth-child(2) > td:nth-child(2) > a");
    private final By notesBy = By.cssSelector("td.markdown > p");
    private By successMessageBy = By.className("alert-success");

    TransferInformation(WebDriver driver){
        this.driver = driver;
    }



    public String getDescription(){
        return driver.findElement(descriptionBy).getText();
    }
    public String getDate(){
        return driver.findElement(dateBy).getText();
    }
    public String getSourceAcount(){
        return driver.findElement(sourceAccountBy).getText();
    }
    public String getDestinationAccount(){
        return driver.findElement(destinationAccountBy).getText();
    }
    public String getAmount(){
        return driver.findElement(amountBy).getText();
    }
    public String getCategory(){
        return driver.findElement(categoryBy).getText();
    }
    public String getNotes(){
        return driver.findElement(notesBy).getText();
    }

    public boolean transferEditSuccess(){
        return driver.findElement(successMessageBy).getText().contains("Updated transfer");
    }
}
