package selenium;

import org.example.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class TransferEditTest {

    private WebDriver driver;
    LoginPage loginPage;
    Transfers allTransfers;
    HomePage homePage;
    private static final String ErrorMessage ="Test Failed:";
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
    private static final String date = "21/01/2025";

    @BeforeEach
    public void setUp(){
        try {
            driver = DriverFactory.getDriver();
            driver.manage().window().maximize();
            loginPage = new LoginPage(driver);
            homePage = new HomePage(driver);
            loginPage.get();



            HomePage homePage = loginPage.loginAsValidUser(loginEmail, loginPassword);

            AccountCreatePage sourceAccount = homePage.createAccountButton(accountType);
            homePage = sourceAccount.createAccount(sourceAccountName, sourceAccountNumber, balance, date);

            AccountCreatePage destinationAccount = homePage.createAccountButton(accountType);
            homePage = destinationAccount.createAccount(destinationAccountName,destinationAccountNumber,balance,date);

            TransferCreatePage newTransfer = homePage.createTransferButton();
            newTransfer.createCategorizedTransfer(sourceAccountName,destinationAccountName,transferAmount,transferAmount,transferDescription,transferCategory);


        }catch (Exception _){
            System.out.println(ErrorMessage);
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
        editTransfer.editCategory(transferEditCategory);
        editTransfer.editNotes(transferNewNotes);


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
            System.out.println(ErrorMessage+" editTransferAmount");
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
            System.out.println(ErrorMessage+" editDescription");
        }
    }
    @Test
    public void editNotes(){

        try {

            allTransfers =  homePage.enterTransfers();
            TransferEditPage editTransfer = allTransfers.pickTransfer(transferDescription);
            editTransfer.editNotes(transferNewNotes);
            TransferInformation transfer = editTransfer.updateTransfer();


            assertTrue(transfer.transferEditSuccess());
            assertEquals(transferNewNotes,transfer.getNotes());
        }catch (Exception _){
            System.out.println(ErrorMessage+" editNotes");
        }


    }

    @AfterEach
    public void tearDown(){
        try {
            homePage.deleteCreatedAccounts();
            driver.quit();
        }catch (Exception _){
            System.out.println(ErrorMessage+" tearDown");
        }

    }




}
