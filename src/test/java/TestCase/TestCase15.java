package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.BaseTest;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.CreateAccountSuccess;
import Pages.DeleteAccount;
import Pages.EnterAccountInfoPage;
import Pages.HomePage;
import Pages.LoginSignupPage;
import Pages.PaymentPage;
import Utils.AddressData;
import Utils.CardData;
import Utils.UserData;

public class TestCase15 extends BaseTest {

    @Test
    public void checkoutAfterRegister() {

        UserData user = createUserData();
        AddressData address = createAddressData();
        CardData card = createCardData();

        LoginSignupPage loginSignupPage = goToSignupPage();
        HomePage homePage = registerAccount(loginSignupPage, user, address);

        CartPage cartPage = addProductAndGoToCart(homePage);

        CheckoutPage checkoutPage = goToCheckout(cartPage);
        verifyCheckoutInfo(checkoutPage, address);

        PaymentPage paymentPage = placeOrder(checkoutPage);
        fillPaymentAndPay(paymentPage, card);

        // deleteAccount();
    }

    private UserData createUserData() {
        return new UserData()
                .setTitle("Mr")
                .setPassword("18042004")
                .setDateOfBirth("18", "April", "2004")
                .setOption(true, true);
    }

    private AddressData createAddressData() {
        return new AddressData()
                .setFullName("Huy", "Deliver")
                .setCompany("BKT")
                .setAddress("Tào Xuyên", "")
                .setCountry("Canada", "Miền Bắc", "Thanh hóa")
                .setZipcode("200304")
                .setMobilePhone("0917196589");
    }

    private CardData createCardData() {
        return new CardData()
                .setNameCard("Nguyễn Huy Phát")
                .setNumberCard("0917196589")
                .setCVC("1972")
                .setMonthExpiration("7")
                .setYearExpiration("2026");
    }

    private LoginSignupPage goToSignupPage() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible());
        return homePage.clickSignupLogin();
    }

    private HomePage registerAccount(LoginSignupPage loginSignupPage, UserData user, AddressData address) {
        EnterAccountInfoPage enterAccountInfoPage = loginSignupPage.signup("Huy Phat", "channel@gmail.com");
        Assert.assertTrue(enterAccountInfoPage.isEnterAccountInfoVisible());

        enterAccountInfoPage.fillAccountInfo(user);
        enterAccountInfoPage.fillAddressInfo(address);

        CreateAccountSuccess createAccountSuccess = enterAccountInfoPage.CreateAccount();
        Assert.assertTrue(createAccountSuccess.isAccountCeated());
        createAccountSuccess.redirectAfterCreate();

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isUserLogin());
        return homePage;
    }

    private CartPage addProductAndGoToCart(HomePage homePage) {
        homePage.addToCart();
        homePage.continueShopping();

        CartPage cartPage = homePage.RedirectToCartPage();
        Assert.assertTrue(homePage.isLandedtoCartPage());
        return cartPage;
    }

    private CheckoutPage goToCheckout(CartPage cartPage) {
        cartPage.procceedCheckout(); //
        return new CheckoutPage(driver);
    }

    private void verifyCheckoutInfo(CheckoutPage checkoutPage, AddressData address) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(
                checkoutPage.isNameOrderRight(address.getFirstName() + " " + address.getLastName()),
                "Tên order không trùng khớp");
        softAssert.assertTrue(
                checkoutPage.isCompanyOrder(address.getCompany()),
                "Tên công ty không đúng");
        softAssert.assertTrue(
                checkoutPage.isAddressOrder1(address.getAddress1()),
                "Địa chỉ không đúng");
        softAssert.assertTrue(
                checkoutPage.isCityOrder(address.getCity() + " " + address.getState() + " " + address.getZipcode()),
                "Thành phố không đúng");
        softAssert.assertTrue(
                checkoutPage.isCountryOrder(address.getCountry()),
                "Quốc gia không đúng");
        softAssert.assertTrue(
                checkoutPage.isPhoneOrder(address.getMobileNumber()),
                "Số điện thoại không đúng");

        softAssert.assertAll();
    }

    private PaymentPage placeOrder(CheckoutPage checkoutPage) {
        checkoutPage.placeOrder("Che tên sản phẩm");
        return new PaymentPage(driver);
    }

    private void fillPaymentAndPay(PaymentPage paymentPage, CardData card) {
        paymentPage.fillInfoCard(card);
        paymentPage.payOrder();
        Assert.assertTrue(paymentPage.isOrderPlaceSuccess(), "Đặt hàng không thành công");
    }

    private void deleteAccount() {
        HomePage homePage = new HomePage(driver);
        homePage.deleteAccount();

        DeleteAccount deleteAccount = new DeleteAccount(driver);
        Assert.assertTrue(deleteAccount.isAccountDelete(), "Xóa tài khoản không thành công");
        deleteAccount.redirectAfterDelete();
    }
}