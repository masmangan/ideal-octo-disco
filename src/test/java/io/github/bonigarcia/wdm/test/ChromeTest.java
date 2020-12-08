package io.github.bonigarcia.wdm.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.test.pages.HomePage;
import io.github.bonigarcia.wdm.test.pages.RegisterConfirmationPage;
import io.github.bonigarcia.wdm.test.pages.RegisterPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import static io.github.bonigarcia.wdm.test.utils.UsernameGenerator.generateUsername;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChromeTest {

    String user;
    String domain = "@test.io";
    String defaultPassword = "a1b2@c3d4";
    WebDriver driver;
    HomePage home;
    RegisterPage register;
    RegisterConfirmationPage confirmation;


    @Test
    public void sumTest(){
        home = new HomePage(driver);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        home.clickPrivacyAgreementButton();
        home.clickButton3();
        home.clickPlusButton();
        home.clickButton6();
        home.clickCalcButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("9", home.getResultsOnScreen());
    }

    @Test
    public void signUpWithValidDataTest(){
        user = generateUsername();
        home = new HomePage(driver);
        register = home.clickRegisterButton(driver);
        register.inputUsername(user);
        register.inputEmail(user + domain);
        register.inputPassword(defaultPassword);
        register.inputPasswordConfirmation(defaultPassword);
        register.clickTermsOfServiceCheckbox();
        confirmation = register.clickSubmitButton(driver);
        assertEquals(user, confirmation.getConfirmationUsernameText());
        assertEquals(user + domain, confirmation.getEmailConfirmationText());
        assertTrue(confirmation.createAccountButtonIsPresent());
    }

    @Test
    public void signUpWithDivergingPasswords(){
        user = generateUsername();
        home = new HomePage(driver);
        register = home.clickRegisterButton(driver);
        register.inputUsername(user);
        register.inputEmail(user + domain);
        register.inputPassword(defaultPassword);
        register.inputPasswordConfirmation("b@t@tinha42");
        register.clickTermsOfServiceCheckbox();
        register.clickSubmitButton();
        assertEquals("Enter the same password as above", register.getErrorMessage());

    }

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        this.driver = new ChromeDriver(options);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.get("https://web2.0calc.com/");
    }

    @After
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}