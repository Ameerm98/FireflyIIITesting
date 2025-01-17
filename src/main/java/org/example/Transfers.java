package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Transfers {
    private final WebDriver driver;
    public Transfers(WebDriver driver) {
        this.driver = driver;
    }


    public TransferEditPage pickTransfer(String transferName) throws InterruptedException {
        By transferBy = By.cssSelector("a[title='"+transferName+"']");
        driver.findElement(transferBy).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/section[2]/div[1]/div[1]/div/div[1]/div/button")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);
        return new TransferEditPage(driver);
    }
}
