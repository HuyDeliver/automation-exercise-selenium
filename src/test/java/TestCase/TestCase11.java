package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.FooterPage;
import Pages.HomePage;

public class TestCase11 extends BaseTest {
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
}
