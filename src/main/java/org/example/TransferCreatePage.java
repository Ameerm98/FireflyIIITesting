package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class TransferCreatePage {

    private final WebDriver driver;
    private final Actions action ;
    private By categoryInputBy = By.name("category[]");
    private By notesBoxBy = By.name("notes[]");
    private By successMessageBy = By.className("alert-success");
    private By errorMessageBy = By.cssSelector(".alert-danger");
    private By submitButtonBy = By.className("btn-success");


    // Constructor
    public TransferCreatePage(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    // Page Elements

    // Account From Dropdown
    @FindBy(name = "source[]")
    private WebElement accountFromDropdown;

    // Account To Dropdown
    @FindBy(name = "destination[]")
    private WebElement accountToDropdown;

    // Amount Input Field
    @FindBy(name = "amount[]")
    private WebElement amountInput;

    // Date Input Field
    @FindBy(id = "date")
    private WebElement dateInput;

    // Description Input Field
    @FindBy(name = "description[]")
    private WebElement descriptionInput;



    // Methods for Interactions

    public void selectAccountFrom(String accountName) throws InterruptedException {
        accountFromDropdown.click();
        accountFromDropdown.clear();
        accountFromDropdown.sendKeys(accountName);
        Thread.sleep(3000);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);
    }

    public void selectAccountTo(String accountName) throws InterruptedException {
        accountToDropdown.click();
        accountToDropdown.clear();
        accountToDropdown.sendKeys(accountName);
        Thread.sleep(3000);
        action.sendKeys(Keys.ENTER).perform();
        //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Thread.sleep(1000);
    }

    public void enterAmount(String amount) {
        amountInput.clear();
        amountInput.sendKeys(amount);
    }

    public void enterDate(String date) {
        dateInput.clear();
        dateInput.sendKeys(date);
    }

    public void enterDescription(String description) {
        descriptionInput.clear();
        descriptionInput.sendKeys(description);
    }


    public TransferCreatePage createEmptyTransfer(){
        driver.findElement(submitButtonBy).click();
        return this;
    }

    // Method to Perform Full Transfer Creation
    public TransferCreatePage createTransfer(String accountFrom, String accountTo, String amount, String date, String description) throws InterruptedException {

        if (!Objects.equals(accountFrom, "")){
            selectAccountFrom(accountFrom);
            //action.sendKeys(Keys.ARROW_DOWN).perform();
            //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        }

        //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        if (!Objects.equals(accountTo, "")){
            selectAccountTo(accountTo);
            //action.sendKeys(Keys.ARROW_DOWN).perform();

        }
        enterAmount(amount);
        //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Thread.sleep(1000);

        enterDescription(description);
        Thread.sleep(1000);

        //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(submitButtonBy).click();
        Thread.sleep(1000);

        //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        return this;
    }

    public TransferCreatePage createCategorizedTransfer(String accountFrom, String accountTo, String amount, String date, String description, String category) throws InterruptedException {
        driver.findElement(categoryInputBy).click();
        Thread.sleep(1000);
        driver.findElement(categoryInputBy).sendKeys(category);
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);
        return createTransfer(accountFrom,accountTo,amount,date,description);
    }
    public TransferCreatePage addNotesToTransfer(String notes){
        driver.findElement(notesBoxBy).click();
        driver.findElement(notesBoxBy).sendKeys(notes);
        return this;
    }



    public boolean transferCreated(String name){
        return driver.findElement(successMessageBy).getText().contains("Successfully created");
    }


    public boolean transferNotCreated(){
        return driver.findElement(errorMessageBy).getText().contains("Error");
    }

}

