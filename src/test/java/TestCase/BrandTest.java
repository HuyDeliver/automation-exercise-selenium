package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.BrandProductPage;
import Pages.HomePage;
import Pages.ProductPage;

public class BrandTest extends BaseTest {
    @Test
    public void viewBrandProduct() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue(homePage.isHomePageVisible());
        homePage.clickProduct();
        homePage.isNavitoProductPage();

        Assert.assertTrue(productPage.isBrandInSideBar());
        BrandProductPage brandProductPage = new BrandProductPage(driver);
        brandProductPage.clickProduct("Polo");
        Assert.assertTrue(brandProductPage.verifyUrlBrand("Polo"));
        Assert.assertTrue(brandProductPage.verifyProduct());
        brandProductPage.clickProduct("Biba");
        Assert.assertTrue(brandProductPage.verifyUrlBrand("Biba"));
        Assert.assertTrue(brandProductPage.verifyProduct());
    }
}
