package io.github.bonigarcia.wdm.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage{
    @FindBy(id = "inputUsername")
    private WebElement usernameField;
    @FindBy(id = "inputEmail")
    private WebElement emailField;
    @FindBy(id = "inputPassword1")
    private WebElement passwordField;
    @FindBy(id = "inputPassword2")
    private WebElement passwordConfirmationField;
    @FindBy(xpath = "//input[@name='tos']")
    private WebElement termosOfServiceCheckbox;
    @FindBy(id = "submitbtn")
    private WebElement submitButton;
    @FindBy(xpath = "(//span[@class='error'])[4]")
    private WebElement errorMessage;

    public RegisterPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void inputUsername(String username){
        usernameField.sendKeys(username);
    }

    public void inputEmail(String email){
        emailField.sendKeys(email);
    }

    public void inputPassword(String password){
        passwordField.sendKeys(password);
    }

    public void inputPasswordConfirmation(String passwordConfirmation){
        passwordConfirmationField.sendKeys(passwordConfirmation);
    }

    public void clickTermsOfServiceCheckbox(){
        termosOfServiceCheckbox.click();
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public RegisterConfirmationPage clickSubmitButton(WebDriver driver){
        submitButton.click();
        return new RegisterConfirmationPage(driver);
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }
}
