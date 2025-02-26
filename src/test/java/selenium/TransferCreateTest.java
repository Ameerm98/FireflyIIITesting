package selenium;

import org.example.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TransferCreateTest {
    private WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    private static final String loginEmail = "ameertechnion1998@gmail.com";
    private static final String loginPassword = "AmeerFadeAws250298#";
    private static final String accountType = "asset";
    private static final String sourceAccountName = "hapoalim";
    private static final String sourceAccountNumber = "1";
    private static final String destinationAccountName = "mercantel";
    private static final String destinationAccountNumber = "2";
    private static final String balance ="10000";
    private static final String transferEditCategory ="Studies";
    private static final String transferNewNotes ="new added notes";
    private static final String date = "16/01/2025";
    private static final String ErrorMessage ="Test Failed:";



    @BeforeEach
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // New headless mode
        options.addArguments("--no-sandbox");    // Required for CI
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        loginPage.get();
        homePage = new HomePage(driver);

    }


    @Test
    public void emptyTransferCreate() {
        try {
            HomePage homePage = loginPage.loginAsValidUser(loginEmail, loginPassword);
            AccountCreatePage accountCreatePage = homePage.createAccountButton(accountType);
            homePage = accountCreatePage.createAccount(sourceAccountName, sourceAccountNumber, balance, date);
            accountCreatePage = homePage.createAccountButton(accountType);
            accountCreatePage.createAccount(destinationAccountName, destinationAccountNumber, balance, date);
            TransferCreatePage transferCreatePage = homePage.createTransferButton();
            transferCreatePage.createEmptyTransfer();
            assertTrue(transferCreatePage.transferNotCreated());
        } catch (Exception _) {
            System.out.println(ErrorMessage+" emptyTransferCreate");

        }
    }

    @Test
    public void validTransferCreate() {
        try {
            // Login
            HomePage homePage = loginPage.loginAsValidUser(loginEmail, loginPassword);


            // create source account
            AccountCreatePage accountCreatePage = homePage.createAccountButton(accountType);
            homePage = accountCreatePage.createAccount(sourceAccountName, sourceAccountNumber, balance, date);

            //create destination account
            accountCreatePage = homePage.createAccountButton(accountType);
            accountCreatePage.createAccount(destinationAccountName, destinationAccountNumber, balance, date);

            //create transfer between Source account and destination account
            TransferCreatePage transferCreatePage = homePage.createTransferButton();
            transferCreatePage.createTransfer(sourceAccountName, destinationAccountName, balance, date, "transfer all balance");

            //check success message
            assertTrue(transferCreatePage.transferCreated());

        } catch (InterruptedException _){
            System.out.println(ErrorMessage+" validTransferCreate");
        }
    }
    @Test
    public void transferWithNoDescription(){
        try {
            HomePage homePage = loginPage.loginAsValidUser(loginEmail, loginPassword);
            AccountCreatePage accountCreatePage = homePage.createAccountButton(accountType);
            homePage = accountCreatePage.createAccount(sourceAccountName, sourceAccountNumber, balance, date);
            accountCreatePage = homePage.createAccountButton(accountType);
            accountCreatePage.createAccount(destinationAccountName, destinationAccountNumber, balance, date);
            TransferCreatePage transferCreatePage = homePage.createTransferButton();
            transferCreatePage.createTransfer(sourceAccountName, destinationAccountName, balance, date, "");
            assertTrue(transferCreatePage.transferNotCreated());
        } catch (Exception _) {
            System.out.println(ErrorMessage+" transferWithNoDescription");
        }
    }

    @Test
    public void transferWithMissingSourceAccount(){
        try {
            HomePage homePage = loginPage.loginAsValidUser(loginEmail, loginPassword);
            AccountCreatePage accountCreatePage = homePage.createAccountButton(accountType);
            homePage = accountCreatePage.createAccount(sourceAccountName, sourceAccountNumber, balance, date);
            accountCreatePage = homePage.createAccountButton(accountType);
            accountCreatePage.createAccount(destinationAccountName, destinationAccountNumber, balance, date);
            TransferCreatePage transferCreatePage = homePage.createTransferButton();
            transferCreatePage.createTransfer("", destinationAccountName, balance, date, "No Source Account Transfer");
            assertTrue(transferCreatePage.transferCreated());
        } catch (InterruptedException _) {
            System.out.println(ErrorMessage+" transferWithMissingSourceAccount");


        }
    }
    @Test
    public void transferWithMissingDestinationAccount(){
        try {
            HomePage homePage = loginPage.loginAsValidUser(loginEmail, loginPassword);
            AccountCreatePage accountCreatePage = homePage.createAccountButton(accountType);
            homePage = accountCreatePage.createAccount(sourceAccountName, sourceAccountNumber, balance, date);
            accountCreatePage = homePage.createAccountButton(accountType);
            accountCreatePage.createAccount(destinationAccountName, destinationAccountNumber, balance, date);
            TransferCreatePage transferCreatePage = homePage.createTransferButton();
            transferCreatePage.createTransfer(destinationAccountName, "", balance, date, "No Destination Account Transfer");
            assertTrue(transferCreatePage.transferCreated());
        } catch (InterruptedException _) {
            System.out.println(ErrorMessage+" transferWithMissingDestinationAccount");
        }
    }
        /// ////////////// new tests
    @Test
    public void transferWithNonExistanceAccounts(){
        try {
            HomePage homePage = loginPage.loginAsValidUser(loginEmail, loginPassword);
            AccountCreatePage accountCreatePage = homePage.createAccountButton(accountType);
            homePage = accountCreatePage.createAccount(sourceAccountName, sourceAccountNumber, balance, date);
            accountCreatePage = homePage.createAccountButton(accountType);
            accountCreatePage.createAccount(destinationAccountName, destinationAccountNumber, balance, date);
            TransferCreatePage transferCreatePage = homePage.createTransferButton();
            transferCreatePage.createTransfer("unrealAccount", "AccountNotAvailable", balance, date, "transfer all balance");
            assertTrue(transferCreatePage.transferNotCreated());

        } catch (InterruptedException _){
            System.out.println(ErrorMessage+" transferWithNonExistanceAccounts");


        }
    }

    @Test
    public void transferZeroOrNegativeAmount(){
        try {
            HomePage homePage = loginPage.loginAsValidUser(loginEmail, loginPassword);
            AccountCreatePage accountCreatePage = homePage.createAccountButton(accountType);
            homePage = accountCreatePage.createAccount(sourceAccountName, sourceAccountNumber, balance, date);
            accountCreatePage = homePage.createAccountButton(accountType);
            accountCreatePage.createAccount(destinationAccountName, destinationAccountNumber, balance, date);
            TransferCreatePage transferCreatePage = homePage.createTransferButton();
            transferCreatePage.createTransfer(sourceAccountName, destinationAccountName, "-2000", date, "transfer all balance");
            assertTrue(transferCreatePage.transferNotCreated());
            transferCreatePage.createTransfer(sourceAccountName, destinationAccountName, "0", date, "transfer all balance");
            assertTrue(transferCreatePage.transferNotCreated());


        } catch (InterruptedException _){
            System.out.println(ErrorMessage+" transferZeroOrNegativeAmount");


        }
    }

    @Test
    public void transferCategorize(){
        try {
            HomePage homePage = loginPage.loginAsValidUser(loginEmail, loginPassword);

            AccountCreatePage accountCreatePage = homePage.createAccountButton(accountType);
            homePage = accountCreatePage.createAccount(sourceAccountName, sourceAccountNumber, balance, date);

            accountCreatePage = homePage.createAccountButton(accountType);
            homePage = accountCreatePage.createAccount(destinationAccountName, destinationAccountNumber, balance, date);

            CategoryCreatePage category = homePage.createCategory();
            category.createCategory(transferEditCategory);


            TransferCreatePage transferCreatePage = homePage.createTransferButton();
            transferCreatePage.createCategorizedTransfer(sourceAccountName, destinationAccountName, "2000", date, "transfer",transferEditCategory);
            assertTrue(transferCreatePage.transferCreated());
        } catch (InterruptedException _){
            System.out.println(ErrorMessage+" transferCategorize");


        }
    }

    @Test
    public void notedTransferCreate(){
        try {


            HomePage homePage = loginPage.loginAsValidUser(loginEmail, loginPassword);

            AccountCreatePage accountCreatePage = homePage.createAccountButton(accountType);
            homePage = accountCreatePage.createAccount(sourceAccountName, sourceAccountNumber, balance, date);

            accountCreatePage = homePage.createAccountButton(accountType);
            homePage = accountCreatePage.createAccount(destinationAccountName, destinationAccountNumber, balance, date);

            TransferCreatePage transferCreatePage = homePage.createTransferButton();
            transferCreatePage.addNotesToTransfer(transferNewNotes);

            transferCreatePage.createTransfer(sourceAccountName, destinationAccountName, balance, date, "transfer all balance");
            assertTrue(transferCreatePage.transferCreated());
        }catch (Exception _){
            System.out.println(ErrorMessage+" notedTransferCreate");


        }
    }



    @AfterEach
    public void tearDown(){
        try {
            homePage.deleteCreatedAccounts();
            driver.quit();
        }catch (Exception _){


        }

    }

}
