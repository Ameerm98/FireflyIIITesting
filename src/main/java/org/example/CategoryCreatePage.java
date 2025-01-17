package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class CategoryCreatePage {
    private final WebDriver driver;
    private By nameInputBy = By.id("ffInput_name");
    private By submitButtonBy = By.className("btn-success");

    public CategoryCreatePage(WebDriver driver) {
        this.driver =driver;
    }


    public void createCategory(String categoryName){
        driver.findElement(nameInputBy).click();
        driver.findElement(nameInputBy).clear();
        driver.findElement(nameInputBy).sendKeys(categoryName);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.findElement(submitButtonBy).click();
    }











}
