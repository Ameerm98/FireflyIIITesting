package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.time.Duration;

public class HomePage extends LoadableComponent {
    private final String baseURL = "https://a05c-2a06-c701-9ca4-ad00-9cc3-5696-30ab-de32.ngrok-free.app";
    private final WebDriver driver;
    private final By createSideBarBy = By.className("fa-plus-circle");
    private final By assetAccountBy = By.cssSelector("a[href='"+baseURL+"/accounts/create/asset']");
    private final By expenseAccountBy = By.linkText(baseURL+"/accounts/create/expense");
    private final By revenueAccountBy = By.linkText(baseURL+"/accounts/create/revenue");
    private final By billBy = By.linkText(baseURL+"/bills/create");
    private final By budgetBy = By.linkText(baseURL+"/budgets/create");
    private final By piggyBankBy = By.linkText(baseURL+"/piggy-banks/create");
    private final By transferBy = By.cssSelector("a[href='"+baseURL+"/transactions/create/transfer']");
    private final By categoryCreateButtonBy = By.cssSelector("a[href='"+baseURL+"/categories/create']");
    private final By withdrawalBy = By.linkText(baseURL+"/transactions/create/withdrawal");
    private final By budgetsBy = By.linkText(baseURL+"/budgets");
    private final By AccountBy = By.cssSelector("tr:nth-child(2) > td:nth-child(9) > div > button");
    private final By deleteBy = By.cssSelector("div.box-footer > input");


    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @Override
    protected void load(){
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get(baseURL);
    }
    @Override
    protected void isLoaded() throws Error {
        assert(driver.getTitle().contains("Home"));
    }
    public String getTitle(){
        return driver.getTitle();
    }
    public Account createAccountButton(String type){
        driver.findElement(createSideBarBy).click();
        if (type.equals("asset")){
            driver.findElement(assetAccountBy).click();
            return new Account(driver,"asset");
        } else {
            if (type.equals("expense")){
                driver.findElement(expenseAccountBy).click();
                return new Account(driver,"expense");
            }else{
                driver.findElement(revenueAccountBy).click();
                return new Account(driver,"revenue");
            }

        }
    }
    public CategoryCreatePage createCategory(){
        driver.findElement(createSideBarBy).click();
        driver.findElement(categoryCreateButtonBy).click();
        return new CategoryCreatePage(driver);

    }


    public TransferCreatePage createTransferButton(){
        driver.findElement(createSideBarBy).click();
        driver.findElement(transferBy).click();
        return new TransferCreatePage(driver);
    }

    public Transfers enterTransfers() throws InterruptedException {
        driver.get(baseURL+"/transactions/transfers");
        Thread.sleep(1000);
        //driver.findElement(TransfersBy).click();
        driver.findElement(By.cssSelector("a[href='"+baseURL+"/transactions/transfer/all']")).click();
        return new Transfers(driver);
    }

    public void deleteCreatedAccounts(){
        driver.get(baseURL+"/accounts/asset");
        driver.findElement(AccountBy).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ENTER).perform();
        driver.findElement(deleteBy).click();
        driver.findElement(AccountBy).click();
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ENTER).perform();
        driver.findElement(deleteBy).click();
    }




}
