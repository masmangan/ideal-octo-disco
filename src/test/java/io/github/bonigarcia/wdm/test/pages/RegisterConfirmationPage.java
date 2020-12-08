package io.github.bonigarcia.wdm.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterConfirmationPage {
    @FindBy(xpath = "(//div[@class='col-sm-5'])[1]")
    private WebElement usernameConfirmation;
    @FindBy(xpath = "(//div[@class='col-sm-5'])[2]")
    private WebElement emailConfirmation;
    @FindBy(id = "submitbtn")
    private WebElement createAccountButton;

    public RegisterConfirmationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String getConfirmationUsernameText(){
        return usernameConfirmation.getText();
    }

    public String getEmailConfirmationText(){
        return emailConfirmation.getText().trim();
    }

    public boolean createAccountButtonIsPresent(){
        return createAccountButton.isDisplayed();
    }
}
