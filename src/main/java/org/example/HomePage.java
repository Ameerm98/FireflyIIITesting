package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends LoadableComponent {
    private final String baseURL = "https://0217-2a06-c701-9ca4-ad00-9cc3-5696-30ab-de32.ngrok-free.app";
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
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseURL);
        try {
            Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement visitSiteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Visit Site']")));
            visitSiteButton.click();
        } catch (TimeoutException err) {
            System.out.println("Ngrok warning page was not loaded");
        }
    }
    @Override
    protected void isLoaded() throws Error {
        assert(driver.getTitle().contains("Home"));
    }
    public String getTitle(){
        return driver.getTitle();
    }
    public AccountCreatePage createAccountButton(String type){
        try {
            driver.findElement(createSideBarBy).click();
            Thread.sleep(1000);
            if (type.equals("asset")){
                driver.findElement(assetAccountBy).click();
                Thread.sleep(1000);
                return new AccountCreatePage(driver,"asset");
            } else {
                if (type.equals("expense")){
                    driver.findElement(expenseAccountBy).click();
                    return new AccountCreatePage(driver,"expense");
                }else{
                    driver.findElement(revenueAccountBy).click();
                    return new AccountCreatePage(driver,"revenue");
                }

            }

        } catch (Exception _) {

        }
        return null;
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
        Thread.sleep(2000);
        //driver.findElement(TransfersBy).click();
        driver.findElement(By.cssSelector("a[href='"+baseURL+"/transactions/transfer/all']")).click();
        return new Transfers(driver);
    }

    public void deleteCreatedAccounts() throws InterruptedException {
        driver.get(baseURL+"/accounts/asset");

        driver.findElement(AccountBy).click();
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);

        action.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);

        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

        driver.findElement(deleteBy).click();
        Thread.sleep(2000);

        driver.findElement(AccountBy).click();
        Thread.sleep(2000);

        action.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);

        action.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);

        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

        driver.findElement(deleteBy).click();
        Thread.sleep(2000);

    }




}
