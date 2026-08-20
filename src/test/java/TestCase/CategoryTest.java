package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.CategoryPage;
import Pages.HomePage;

public class CategoryTest extends BaseTest {
    @Test
    public void viewCategoryProducts() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible());

        Assert.assertTrue(homePage.verifySidebar());
        homePage.womenCategoryClick();
        homePage.goTocategoryProduct();

        CategoryPage categoryPage = new CategoryPage(driver);
        Assert.assertTrue(categoryPage.verifyUrlCategory("https://automationexercise.com/category_products/"),
                "Khôn đúng trang");
        Assert.assertTrue(categoryPage.verifyTitleCategory());
        categoryPage.manCategoryClick();
        categoryPage.goTomancategoryProduct();
    }
}
