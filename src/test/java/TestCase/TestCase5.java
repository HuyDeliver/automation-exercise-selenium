package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginSignupPage;

public class TestCase5 extends BaseTest {
    @Test
    public void registerFail() {
        LoginSignupPage loginSignupPage = goToSignupPage();
        loginSignupPage.signup("Huy Phat", "channel@gmail.com");
        Assert.assertTrue(loginSignupPage.isSignupFail());
    }

    // ===== HELPERS =====
    private LoginSignupPage goToSignupPage() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible());
        LoginSignupPage loginSignupPage = homePage.clickSignupLogin();
        Assert.assertTrue(loginSignupPage.isNewUserSignupVisible());
        return loginSignupPage;
    }
}
