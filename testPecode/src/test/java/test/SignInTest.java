package test;

import config.ConfigProvider;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class SignInTest extends BaseTest {


    private static final String ERROR_MESSAGE_INCORRECT_LOGIN = "No account found with that username.";
    private static final String ERROR_MESSAGE_INCORRECT_PASSWORD = "The password you entered was not valid.";
    private static final String ERROR_MESSAGE_LOGIN_IS_EMPTY = "Please enter username.";
    private static final String ERROR_MESSAGE_PASSWORD_IS_EMPTY = "Please enter your password.";

    @Test(priority = 1, description = "User sent invalid login and invalid password and sees error message")
    public void userSentInvalidLoginAndInvalidPasswordAndErrorMessage() {
        Assert.assertTrue(getSignInPage().logoIsVisible());
        getSignInPage().sentLogin("qwerty");
        getSignInPage().sentPassword(ConfigProvider.PASSWORD);
        getSignInPage().clickLoginButton();
        Assert.assertTrue(getSignInPage().errorMessageIsVisible());
        Assert.assertEquals(getSignInPage().getErrorMessage(), ERROR_MESSAGE_INCORRECT_LOGIN);
    }

    @Test(priority = 2, description = "User sent valid login and invalid password and sees error message")
    public void userSentValidLoginAndInvalidPasswordAndErrorMessage() {
        Assert.assertTrue(getSignInPage().logoIsVisible());
        getSignInPage().sentLogin(ConfigProvider.LOGIN);
        getSignInPage().sentPassword(ConfigProvider.PASSWORD);
        getSignInPage().clickLoginButton();
        Assert.assertTrue(getSignInPage().errorMessageIsVisible());
        Assert.assertEquals(getSignInPage().getErrorMessage(), ERROR_MESSAGE_INCORRECT_PASSWORD);
    }

    @Test(priority = 3, description = "User sent login but not sent password")
    public void userSentLoginButNotSentPassword() {
        Assert.assertTrue(getSignInPage().logoIsVisible());
        getSignInPage().sentLogin(ConfigProvider.LOGIN);
        getSignInPage().clickLoginButton();
        Assert.assertTrue(getSignInPage().errorMessageIsVisible());
        Assert.assertEquals(getSignInPage().getErrorMessage(), ERROR_MESSAGE_PASSWORD_IS_EMPTY);
    }

    @Test(priority = 4, description = "User sent password but not sent login")
    public void userSentPasswordButNotSentLogin() {
        Assert.assertTrue(getSignInPage().logoIsVisible());
        getSignInPage().sentPassword(ConfigProvider.PASSWORD);
        getSignInPage().clickLoginButton();
        Assert.assertTrue(getSignInPage().errorMessageIsVisible());
        Assert.assertEquals(getSignInPage().getErrorMessage(), ERROR_MESSAGE_LOGIN_IS_EMPTY);
    }

    @Test(priority = 5, description = "User does not see logo") //this test should be failed
    public void userDoesNotSeeLogo() {
        Assert.assertFalse(getSignInPage().logoIsVisible());
    }
}
