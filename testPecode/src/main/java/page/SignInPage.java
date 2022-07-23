package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@placeholder='Username']")
    private WebElement loginField;

    @FindBy(xpath = "//*[@placeholder='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@class='btn btn-success']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@class='form-group has-error']//*[@class='help-block']")
    private WebElement errorMessage;

    @FindBy(xpath = "//*[@id='logomini']")
    private WebElement logo;

    public boolean logoIsVisible() {
        return logo.isDisplayed();
    }

    public boolean errorMessageIsVisible() {
        return errorMessage.isDisplayed();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void sentLogin(String login) {
        loginField.sendKeys(login);
    }

    public void sentPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

}
