package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;

public class TestCase12 extends BaseTest {
    @Test
    public void addToCart() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue(homePage.isHomePageVisible());
        homePage.clickProduct();
        productPage.addToCart(1);
        productPage.continueShopping();

        productPage.addToCart(2);
        productPage.viewCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.verifyProduct().size(), 2);
    }
}
