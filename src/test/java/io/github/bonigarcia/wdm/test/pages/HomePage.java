package io.github.bonigarcia.wdm.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    @FindBy(xpath = "//span[contains(text(), 'Register')]")
    private WebElement registerButton;


    public HomePage(WebDriver driver){
        super(driver);
    }

    public RegisterPage clickRegisterButton(){
        this.registerButton.click();
        return new RegisterPage(driver);
    }


}
