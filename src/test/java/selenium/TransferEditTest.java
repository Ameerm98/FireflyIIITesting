package selenium;

import org.example.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class TransferEditTest {

    private WebDriver driver;
    LoginPage loginPage;
    Transfers allTransfers;
    HomePage homePage;
    private static final String setUpErrorMessage ="setUp Failed";
    private static final String expectedPageTitle = "Spotify Clone";
    private static final String loginEmail = "ameertechnion1998@gmail.com";
    private static final String loginPassword = "AmeerFadeAws250298#";
    private static final String accountType = "asset";
    private static final String sourceAccountName = "hapoalim";
    private static final String sourceAccountNumber = "1";
    private static final String destinationAccountName = "mercantel";
    private static final String destinationAccountNumber = "2";
    private static final String balance ="10000";
    private static final String transferAmount ="1000";
    private static final String transferEditAmount ="100";
    private static final String transferDescription ="new Transfer Created";
    private static final String transferEditDescription = "editedDescription";
    private static final String transferCategory ="mobile";
    private static final String transferEditCategory ="Studies";
    private static final String transferNewNotes ="new added notes";
    private static final String date = "16/01/2025";

    @BeforeEach
    public void setUp(){
        try {


            driver = new ChromeDriver();
            driver.manage().window().maximize();
            loginPage = new LoginPage(driver);
            homePage = new HomePage(driver);
            loginPage.get();

            try {
                Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));
                WebElement visitSiteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Visit Site']")));
                visitSiteButton.click();
            } catch (TimeoutException err) {
                System.out.println("Ngrok warning page was not loaded");
            }


            HomePage homePage = loginPage.loginAsValidUser(loginEmail, loginPassword);

            Account sourceAccount = homePage.createAccountButton(accountType);
            homePage = sourceAccount.createAccount(sourceAccountName, sourceAccountNumber, balance, date);

            Account destinationAccount = homePage.createAccountButton(accountType);
            homePage = destinationAccount.createAccount(destinationAccountName,destinationAccountNumber,balance,date);

            TransferCreatePage newTransfer = homePage.createTransferButton();
            newTransfer.createCategorizedTransfer(sourceAccountName,destinationAccountName,transferAmount,transferAmount,transferDescription,transferCategory);


        }catch (Exception _){
            System.out.println(setUpErrorMessage);
        }
    }


    @Test
    public void editAllFields() throws InterruptedException {
        allTransfers =  homePage.enterTransfers();
        TransferEditPage editTransfer = allTransfers.pickTransfer(transferDescription);

        editTransfer.editDescription(transferEditDescription);
        editTransfer.editSourceAccount(sourceAccountName);
        editTransfer.editDestinationAccount(destinationAccountName);
        editTransfer.editAmount(transferAmount);
        editTransfer.editTransferCategory(transferEditCategory);
        editTransfer.editTransferNotes(transferNewNotes);


        TransferInformation transfer = editTransfer.updateTransfer();
        assertTrue(transfer.transferEditSuccess());
        assertEquals(transferEditDescription,transfer.getDescription());
        assertEquals(sourceAccountName,transfer.getSourceAcount());
        assertEquals(destinationAccountName,transfer.getDestinationAccount());
        assertEquals("₪1,000.00",transfer.getAmount());
        assertEquals(transferEditCategory,transfer.getCategory());
        assertEquals(transferNewNotes,transfer.getNotes());
    }


    @Test
    public void editTransferAmount(){

        try {
            allTransfers =  homePage.enterTransfers();
            TransferEditPage editTransfer = allTransfers.pickTransfer(transferDescription);
            editTransfer.editAmount(transferEditAmount);
            TransferInformation transfer = editTransfer.updateTransfer();
            assertTrue(transfer.transferEditSuccess());
            assertEquals("₪100.00",transfer.getAmount());



        }catch (Exception _){

        }
    }

    @Test
    public void editDescription(){
        try {
            allTransfers =  homePage.enterTransfers();
            TransferEditPage editTransfer = allTransfers.pickTransfer(transferDescription);
            editTransfer.editDescription(transferEditDescription);
            TransferInformation transfer = editTransfer.updateTransfer();
            assertTrue(transfer.transferEditSuccess());
            assertEquals(transferEditDescription,transfer.getDescription());

        }catch (Exception _){

        }
    }
    @Test
    public void editNotes(){

        try {

            allTransfers =  homePage.enterTransfers();
            TransferEditPage editTransfer = allTransfers.pickTransfer(transferDescription);
            editTransfer.editTransferNotes(transferNewNotes);
            TransferInformation transfer = editTransfer.updateTransfer();


            assertTrue(transfer.transferEditSuccess());
            assertEquals(transferNewNotes,transfer.getNotes());
        }catch (Exception _){

        }


    }

    @AfterEach
    public void tearDown(){
        homePage.deleteCreatedAccounts();
        driver.quit();


    }




}
