package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferEditPage {
    private final WebDriver driver;
    Actions action ;
    private By categoryInputBy = By.name("category[]");
    private By notesBoxBy = By.name("notes[]");
    private By successMessageBy = By.className("alert-success");
    private By errorMessageBy = By.cssSelector(".alert-danger");
    private By submitButtonBy = By.className("btn-success");


    // Constructor
    public TransferEditPage(WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
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


    // Description Input Field
    @FindBy(name = "description[]")
    private WebElement descriptionInput;

    @FindBy(name="category[]")
    private WebElement categoryInput;

    @FindBy(name="notes[]")
    private WebElement notesBox;



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


    public TransferEditPage editDescription(String description){
        descriptionInput.click();
        descriptionInput.clear();
        descriptionInput.sendKeys(description);
        return this;
    }

    public TransferEditPage editSourceAccount(String name) throws InterruptedException {
        selectAccountFrom(name);
        return this;
    }
    public TransferEditPage editDestinationAccount(String name) throws InterruptedException {
        selectAccountTo(name);
        return this;
    }

    public TransferEditPage editAmount(String amount){
        amountInput.click();
        amountInput.clear();
        amountInput.sendKeys(amount);
        return this;
    }
    public TransferEditPage editCategory(String category) throws InterruptedException {
        categoryInput.click();
        categoryInput.clear();
        Thread.sleep(1000);
        categoryInput.sendKeys(category);
        Thread.sleep(2000);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);
        return this;
    }

    public TransferEditPage editNotes(String note) throws InterruptedException {
        notesBox.click();
        notesBox.clear();
        Thread.sleep(2000);
        notesBox.sendKeys(note);
        Thread.sleep(2000);
        return this;
    }

    public TransferInformation updateTransfer() throws InterruptedException {
    driver.findElement(submitButtonBy).click();
    Thread.sleep(1000);
        return new TransferInformation(driver);
    }


}
