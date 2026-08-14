package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginSignupPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginAccountSuccess() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible());

        LoginSignupPage loginSignupPage = homePage.clickSignupLogin();
        Assert.assertTrue(loginSignupPage.isNewUserSignupVisible());
        Assert.assertTrue(loginSignupPage.isLoginFormVisible());

        loginSignupPage.login("channel@gmail.com", "18042004");
    }

    @Test
    public void loginAccountFail() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible());

        LoginSignupPage loginSignupPage = homePage.clickSignupLogin();
        Assert.assertTrue(loginSignupPage.isNewUserSignupVisible());
        Assert.assertTrue(loginSignupPage.isLoginFormVisible());

        loginSignupPage.login("channel@gmail.com", "1804");

        Assert.assertTrue(loginSignupPage.isLoginFail());
    }

    @Test
    public void Logout() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible());

        LoginSignupPage loginSignupPage = homePage.clickSignupLogin();
        Assert.assertTrue(loginSignupPage.isNewUserSignupVisible());
        Assert.assertTrue(loginSignupPage.isLoginFormVisible());

        loginSignupPage.login("channel@gmail.com", "18042004");

        homePage.logOut();

        Assert.assertTrue(homePage.isNavitoLoginPage());
    }
}