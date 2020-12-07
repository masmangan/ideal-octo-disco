package io.github.bonigarcia.wdm.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageObject{
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

    public RegisterPage(WebDriver driver){
        super(driver);
    }

    public void inputUsername(String username){
        this.usernameField.sendKeys(username);
    }

    public void inputEmail(String email){
        this.emailField.sendKeys(email);
    }

    public void inputPassword(String password){
        this.passwordField.sendKeys(password);
    }

    public void inputPasswordConfirmation(String passwordConfirmation){
        this.passwordConfirmationField.sendKeys(passwordConfirmation);
    }

    public void clickTermsOfServiceCheckbox(){
        this.termosOfServiceCheckbox.click();
    }

    public void clickSubmitButton(){
        this.submitButton.click();
    }
}
