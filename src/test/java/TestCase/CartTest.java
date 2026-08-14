package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.FooterPage;
import Pages.HomePage;
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
        productPage.addToCart(0);
        productPage.continueShopping();

        productPage.addToCart(1);
        productPage.viewCart();
    }

}
