package TestCase1;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.HomePage;

public class HomeTest extends BaseTest {
    @Test
    public void accessTestCasePage() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible());
        homePage.clickTestCasePage();
        Assert.assertTrue(homePage.isNavitoTestCasePage());

    }
}
