package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginSignupPage;

public class TestCase4 extends BaseTest {
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
