package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductDetail;

public class TestCase13 extends BaseTest {
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
}
