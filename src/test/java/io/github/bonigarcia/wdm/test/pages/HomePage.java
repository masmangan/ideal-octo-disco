package io.github.bonigarcia.wdm.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{

    @FindBy(xpath = "//a/span[contains(text(), 'Register')]")
    private WebElement registerButton;
    @FindBy(id = "Btn3")
    private WebElement number3Button;
    @FindBy(id = "Btn6")
    private WebElement number6Button;
    @FindBy(id = "BtnPlus")
    private WebElement operationPlusButton;
    @FindBy(id = "BtnCalc")
    private WebElement buttonCalc;
    @FindBy(id = "input")
    private WebElement calculatorScreen;
    @FindBy(xpath = "//button[@class='sc-ifAKCX ivrbXK']")
    private WebElement privacyAgreementButton;


    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public RegisterPage clickRegisterButton(WebDriver driver){
        registerButton.click();
        return new RegisterPage(driver);
    }

    public void clickButton3(){
        number3Button.click();
    }

    public void clickButton6(){
        number6Button.click();
    }

    public void clickPlusButton(){
        operationPlusButton.click();
    }

    public void clickCalcButton(){
        buttonCalc.click();
    }

    public String getResultsOnScreen(){
        return calculatorScreen.getAttribute("value");
    }

    public void clickPrivacyAgreementButton(){
        privacyAgreementButton.click();
    }


}
