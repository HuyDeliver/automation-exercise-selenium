package TestCase1;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.CreateAccountSuccess;
import Pages.DeleteAccount;
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

        UserData address = new UserData()
                .setFullName("Huy", "Deliver")
                .setCompany("BKT")
                .setAddress("Tào Xuyên", "")
                .setCountry("Canada", "Miền Bắc", "Thanh hóa")
                .setZipcode("200304")
                .setMobilePhone("0917196589");
        enterAccountInfoPage.fillAddressInfo(address);

        enterAccountInfoPage.CreateAccount();
        CreateAccountSuccess createAccountSuccess = new CreateAccountSuccess(driver);
        Assert.assertTrue(createAccountSuccess.isAccountCeated());

        createAccountSuccess.redirectAfterCreate();

        Assert.assertTrue(homePage.isUserLogin());

        homePage.deleteAccount();

        DeleteAccount deleteAccount = new DeleteAccount(driver);
        Assert.assertTrue(deleteAccount.isAccountDelete());

        deleteAccount.redirectAfterDelete();
    }
}