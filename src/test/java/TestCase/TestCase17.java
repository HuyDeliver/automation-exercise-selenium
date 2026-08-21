package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.CartPage;
import Pages.HomePage;

public class TestCase17 extends BaseTest {
    @Test
    public void removeProductFromCart() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible());
        homePage.addToCart();
        homePage.continueShopping();
        homePage.RedirectToCartPage();
        homePage.isLandedtoCartPage();
        CartPage cartPage = new CartPage(driver);
        cartPage.deleteProduct();
        Assert.assertEquals(cartPage.verifyProduct().size(), 0);
    }
}
