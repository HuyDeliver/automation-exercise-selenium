package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.CreateAccountSuccess;
import Pages.DeleteAccount;
import Pages.EnterAccountInfoPage;
import Pages.HomePage;
import Pages.LoginSignupPage;
import Utils.AddressData;
import Utils.UserData;

public class RegisterTest extends BaseTest {

    @Test
    public void createAccount() {
        LoginSignupPage loginSignupPage = goToSignupPage();
        EnterAccountInfoPage enterAccountInfoPage = loginSignupPage.signup("Huy Phat", "channel@gmail.com");
        Assert.assertTrue(enterAccountInfoPage.isEnterAccountInfoVisible());

        fillAllInfo(enterAccountInfoPage);
        verifyAccountCreatedAndCleanup();
    }

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

    private void fillAllInfo(EnterAccountInfoPage page) {
        UserData user = new UserData()
                .setTitle("Mr")
                .setPassword("18042004")
                .setDateOfBirth("18", "April", "2004")
                .setOption(true, true);
        page.fillAccountInfo(user);

        AddressData address = new AddressData()
                .setFullName("Huy", "Deliver")
                .setCompany("BKT")
                .setAddress("Tào Xuyên", "")
                .setCountry("Canada", "Miền Bắc", "Thanh hóa")
                .setZipcode("200304")
                .setMobilePhone("0917196589");
        page.fillAddressInfo(address);

        page.CreateAccount();
    }

    private void verifyAccountCreatedAndCleanup() {
        CreateAccountSuccess createAccountSuccess = new CreateAccountSuccess(driver);
        Assert.assertTrue(createAccountSuccess.isAccountCeated());
        createAccountSuccess.redirectAfterCreate();

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isUserLogin());
        homePage.deleteAccount();

        DeleteAccount deleteAccount = new DeleteAccount(driver);
        Assert.assertTrue(deleteAccount.isAccountDelete());
        deleteAccount.redirectAfterDelete();
    }
}