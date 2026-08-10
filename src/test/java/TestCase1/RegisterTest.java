package TestCase1;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.EnterAccountInfoPage;
import Pages.HomePage;
import Pages.LoginSignupPage;
import Utils.UserData;

public class RegisterTest extends BaseTest {

    @Test
    public void createAccount() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible());

        LoginSignupPage loginSignupPage = homePage.clickSignupLogin();
        Assert.assertTrue(loginSignupPage.isNewUserSignupVisible());
        EnterAccountInfoPage enterAccountInfoPage = loginSignupPage.signup("Huy Phat", "channel@gmail.com");

        Assert.assertTrue(enterAccountInfoPage.isEnterAccountInfoVisible());

        UserData user = new UserData()
                .setTitle("Mr")
                .setPassword("18042004")
                .setDateOfBirth("18", "April", "2004")
                .setOption(true, true);

        enterAccountInfoPage.fillAccountInfo(user);
    }
}