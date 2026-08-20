package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.CartPage;
import Pages.FooterPage;
import Pages.HomePage;
import Pages.ProductDetail;
import Pages.ProductPage;

public class CartTest extends BaseTest {
    @Test
    public void fillSubscription() {
        HomePage homePage = new HomePage(driver);
        FooterPage footerPage = new FooterPage(driver);
        Assert.assertTrue(homePage.isHomePageVisible());
        homePage.RedirectToCartPage();
        Assert.assertTrue(footerPage.isSubcriptionVisible());
        footerPage.subcription("Channelbaby15@gmail.com");
        Assert.assertTrue(footerPage.isSubcripAlert());
    }

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

    @Test
    public void verifyProductQuantity() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible());
        homePage.redirectProductDetail();
        homePage.isLandedToProductDetail();

        ProductDetail productDetail = new ProductDetail(driver);
        productDetail.increaseQuantity("4");
        productDetail.addToCart();
        productDetail.viewCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.verifyProduct().size(), 1);
        Assert.assertTrue(cartPage.verifyQuantity("4"));
    }

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
