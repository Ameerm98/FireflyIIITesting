package selenium;

import org.example.DriverFactory;
import org.example.HomePage;
import org.example.LoginPage;
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

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private final String baseURL = "http://localhost:80";

    private static final String loginEmail = "ameertechnion1998@gmail.com";
    private static final String loginPassword = "AmeerFadeAws250298#";
    private static final String invalidLoginEmail = "00000@00000.com";
    private static final String invalidCredentialsMessage = "These credentials do not match our records.";
    private static final String resetPasswordSuccessMessage = "Thank you. If an account exists with this email address, you will find instructions in your inbox.";
    @BeforeEach
    public void setUp(){
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        loginPage.get();
    }



    @Test
    public void testValidLogin() {

        HomePage home = loginPage.loginAsValidUser(loginEmail, loginPassword);
        assertTrue(home.getTitle().contains("Home"));
    }

    @Test
    public void testInValidLogin(){
        LoginPage page = loginPage.loginAsInvalidUser(invalidLoginEmail, loginPassword);
        assertTrue(page.getTitle().contains("Login"));
        assertEquals(invalidCredentialsMessage, page.invalidCredentialsMessage());
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }




}
