package io.github.bonigarcia.wdm.test;

import io.github.bonigarcia.wdm.test.pages.HomePage;
import io.github.bonigarcia.wdm.test.pages.RegisterPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import static io.github.bonigarcia.wdm.test.utils.UsernameGenerator.generateUsername;

public class ChromeTest extends FunctionalTest {

    String user;
    String email = user+"@test.io";
    String defaultPassword = "a1b2@c3d4";
    WebDriver driver;
    HomePage home;
    RegisterPage register;

    @Test
    public void signUpWithValidDataTest(){
        user = generateUsername();
        home = new HomePage(driver);
        register = home.clickRegisterButton();
        register.inputUsername(user);
        register.inputEmail(email);
        register.inputPassword(defaultPassword);
        register.inputPasswordConfirmation(defaultPassword);
        register.clickTermsOfServiceCheckbox();


    }




}