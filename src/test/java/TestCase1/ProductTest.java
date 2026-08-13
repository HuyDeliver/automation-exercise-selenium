package TestCase1;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.BaseTest;
import Pages.HomePage;
import Pages.ProductDetail;
import Pages.ProductPage;

public class ProductTest extends BaseTest {

    @Test
    public void accessProduct() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        ProductDetail productDetail = new ProductDetail(driver);
        Assert.assertTrue(homePage.isHomePageVisible());
        homePage.clickProduct();
        homePage.isNavitoProductPage();
        Assert.assertTrue(productPage.isProductListVisible());
        productPage.redirectProductDetail();
        Assert.assertTrue(productPage.isLandedToProductPage());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productDetail.isproductNameVisible());
        softAssert.assertTrue(productDetail.isproductCategoryVisible());
        softAssert.assertTrue(productDetail.isproductPriceVisible());
        softAssert.assertTrue(productDetail.isproductAvailabilityVisible());
        softAssert.assertTrue(productDetail.isproductConditionVisible());
        softAssert.assertTrue(productDetail.isproductBrandVisible());
        softAssert.assertAll();
    }

    @Test
    public void searchProduct() {
        String keywordSearch = "For";
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue(homePage.isHomePageVisible());
        homePage.clickProduct();
        homePage.isNavitoProductPage();
        Assert.assertTrue(productPage.isProductListVisible());
        productPage.searchProduct(keywordSearch);
        Assert.assertTrue(productPage.isTitleSearchVisible());
        List<String> products = productPage.isAllProductSearchedVisible();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(products.isEmpty());
        for (String name : products) {
            softAssert.assertTrue(name.toLowerCase().contains(keywordSearch.toLowerCase()));
        }
        softAssert.assertAll();
    }
}
