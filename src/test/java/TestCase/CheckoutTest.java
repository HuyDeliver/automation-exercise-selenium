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

public class CheckoutTest extends BaseTest {

        @Test
        public void registerWhileCheckout() {
                UserData user = createUserData();
                AddressData address = createAddressData();
                CardData card = createCardData();

                CartPage cartPage = addProductAndGoToCart();
                LoginSignupPage loginSignupPage = goToLoginFromCart(cartPage);
                HomePage homePage = registerNewAccount(loginSignupPage, user, address);

                CheckoutPage checkoutPage = goToCheckout(homePage);
                verifyCheckoutInfo(checkoutPage, address);

                PaymentPage paymentPage = placeOrder(checkoutPage);
                payOrder(paymentPage, card);

                deleteAccount();
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

        private CartPage addProductAndGoToCart() {
                HomePage homePage = new HomePage(driver);
                Assert.assertTrue(homePage.isHomePageVisible());

                homePage.addToCart();
                homePage.continueShopping();
                homePage.RedirectToCartPage();
                Assert.assertTrue(homePage.isLandedtoCartPage());

                return new CartPage(driver);
        }

        private LoginSignupPage goToLoginFromCart(CartPage cartPage) {
                cartPage.procceedCheckout();
                cartPage.redirLoginSignupPage();
                return new LoginSignupPage(driver);
        }

        private HomePage registerNewAccount(LoginSignupPage loginSignupPage, UserData user, AddressData address) {
                EnterAccountInfoPage enterAccountInfoPage = loginSignupPage.signup("Huy Phat", "channel@gmail.com");

                Assert.assertTrue(enterAccountInfoPage.isEnterAccountInfoVisible());

                enterAccountInfoPage.fillAccountInfo(user);
                enterAccountInfoPage.fillAddressInfo(address);
                enterAccountInfoPage.CreateAccount();

                CreateAccountSuccess createAccountSuccess = new CreateAccountSuccess(driver);
                Assert.assertTrue(createAccountSuccess.isAccountCeated());

                createAccountSuccess.redirectAfterCreate();

                HomePage homePage = new HomePage(driver);
                Assert.assertTrue(homePage.isUserLogin());

                return homePage;
        }

        private CheckoutPage goToCheckout(HomePage homePage) {
                homePage.RedirectToCartPage();

                CartPage cartPage = new CartPage(driver);
                cartPage.procceedCheckout();

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
                                checkoutPage.isCityOrder(address.getCity() + " " + address.getState() + " "
                                                + address.getZipcode()),
                                "Địa chỉ thành phố không đúng");

                softAssert.assertTrue(
                                checkoutPage.isCountryOrder(address.getCountry()),
                                "Quốc gia không đúng");

                softAssert.assertTrue(
                                checkoutPage.isPhoneOrder(address.getMobileNumber()),
                                "Số điện thoại không đúng");

                softAssert.assertAll();
        }

        private PaymentPage placeOrder(CheckoutPage checkoutPage) {
                checkoutPage.placeOrder("che tên sản phẩm");
                return new PaymentPage(driver);
        }

        private void payOrder(PaymentPage paymentPage, CardData card) {
                paymentPage.fillInfoCard(card);
                paymentPage.payOrder();

                Assert.assertTrue(paymentPage.isOrderPlaceSuccess(), "Đơn hàng đặt không thành công");
        }

        private void deleteAccount() {
                HomePage homePage = new HomePage(driver);
                homePage.deleteAccount();

                DeleteAccount deleteAccount = new DeleteAccount(driver);
                Assert.assertTrue(deleteAccount.isAccountDelete(), "Xóa tài khoản không thành công");
                deleteAccount.redirectAfterDelete();
        }
}