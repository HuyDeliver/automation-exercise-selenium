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
        private UserData user;
        private AddressData address;
        private CardData card;

        @Test
        public void registerwhileCheckout() {
                initUserData();
                initAddressData();
                initCardData();
                switchToCartPage();
                switchToLoginPage();
                SignUp();
                accountInfo();
                addressInfo();
                procceedCheckout();
                verifyCheckoutInfo();
                paymentOrder();
                DeleteAccount();
        }

        private void initUserData() {
                user = new UserData()
                                .setTitle("Mr")
                                .setPassword("18042004")
                                .setDateOfBirth("18", "April", "2004")
                                .setOption(true, true);

        }

        private void initAddressData() {
                address = new AddressData()
                                .setFullName("Huy", "Deliver")
                                .setCompany("BKT")
                                .setAddress("Tào Xuyên", "")
                                .setCountry("Canada", "Miền Bắc", "Thanh hóa")
                                .setZipcode("200304")
                                .setMobilePhone("0917196589");

        }

        private void initCardData() {
                card = new CardData()
                                .setNameCard("Nguyễn Huy Phát")
                                .setNumberCard("0917196589")
                                .setCVC("1972")
                                .setMonthExpiration("7")
                                .setYearExpiration("2026");
        }

        private void switchToCartPage() {
                HomePage homePage = new HomePage(driver);
                Assert.assertTrue(homePage.isHomePageVisible());
                homePage.addToCart();
                homePage.continueShopping();
                homePage.RedirectToCartPage();
                Assert.assertTrue(homePage.isLandedtoCartPage());
        }

        private void switchToLoginPage() {
                CartPage cartPage = new CartPage(driver);
                cartPage.procceedCheckout();
                cartPage.redirLoginSignupPage();

        }

        private void SignUp() {
                LoginSignupPage loginSignupPage = new LoginSignupPage(driver);
                EnterAccountInfoPage enterAccountInfoPage = loginSignupPage.signup("Huy Phat", "channel@gmail.com");
                Assert.assertTrue(enterAccountInfoPage.isEnterAccountInfoVisible());
        }

        private void accountInfo() {
                EnterAccountInfoPage enterAccountInfoPage = new EnterAccountInfoPage(driver);

                enterAccountInfoPage.fillAccountInfo(user);
        }

        private void addressInfo() {
                EnterAccountInfoPage enterAccountInfoPage = new EnterAccountInfoPage(driver);
                enterAccountInfoPage.fillAddressInfo(address);

                enterAccountInfoPage.CreateAccount();

        }

        private void procceedCheckout() {
                HomePage homePage = new HomePage(driver);
                CartPage cartPage = new CartPage(driver);
                CreateAccountSuccess createAccountSuccess = new CreateAccountSuccess(driver);
                Assert.assertTrue(createAccountSuccess.isAccountCeated());
                createAccountSuccess.redirectAfterCreate();

                Assert.assertTrue(homePage.isUserLogin());

                homePage.RedirectToCartPage();
                cartPage.procceedCheckout();
        }

        private void verifyCheckoutInfo() {
                CheckoutPage checkoutPage = new CheckoutPage(driver);
                SoftAssert softAssert = new SoftAssert();
                softAssert.assertTrue(
                                checkoutPage.isNameOrderRight(address.getFirstName() + " " + address.getLastName()),
                                "Tên order không trùng khớp");
                softAssert.assertTrue(checkoutPage.isCompanyOrder(address.getCompany()), "tên công ty không đúng");
                softAssert.assertTrue(checkoutPage.isAddressOrder1(address.getAddress1()), "địa chỉ không đúng");
                softAssert.assertTrue(
                                checkoutPage.isCityOrder(address.getCity() + " " + address.getState() + " "
                                                + address.getZipcode()),
                                "địa chỉ thành phố không đúng");
                softAssert.assertTrue(checkoutPage.isCountryOrder(address.getCountry()));
                softAssert.assertTrue(checkoutPage.isPhoneOrder(address.getMobileNumber()), "Số đt không đúng");
                softAssert.assertAll();

                checkoutPage.placeOrder("che tên sản phẩm");
        }

        private void paymentOrder() {

                PaymentPage paymentPage = new PaymentPage(driver);
                paymentPage.fillInfoCard(card);
                paymentPage.payOrder();
                Assert.assertTrue(paymentPage.isOrderPlaceSuccess(), "Đơn hàng đặt không thành công");

        }

        private void DeleteAccount() {
                HomePage homePage = new HomePage(driver);
                homePage.deleteAccount();
                DeleteAccount deleteAccount = new DeleteAccount(driver);
                Assert.assertTrue(deleteAccount.isAccountDelete(), "Xóa tài khoản không thành công");
                deleteAccount.redirectAfterDelete();
        }
}
