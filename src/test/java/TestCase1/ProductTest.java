package TestCase1;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.HomePage;
import Pages.ProductPage;

public class ProductTest extends BaseTest {

    @Test
    public void accessProduct() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue(homePage.isHomePageVisible());
        homePage.clickProduct();
        homePage.isNavitoProductPage();
        Assert.assertTrue(productPage.isProductListVisible());
        productPage.redirectProductDetail();
    }
}
