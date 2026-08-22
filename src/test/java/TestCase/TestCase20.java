package TestCase;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.BaseTest;
import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginSignupPage;
import Pages.ProductPage;

public class TestCase20 extends BaseTest {
    @Test
    public void searchProductAndVerifyCartAfterLogin() {
        String keyword = "Tshirt";
        ProductPage productPage = goToProductPage();

        ProductPage productAfterSearch = searchProduct(productPage, keyword);
        List<String> products = productPage.isAllProductSearchedVisible();
        verifyProductRelatedSearchKey(productAfterSearch, keyword, products);

        addAllProductToCart(productPage);
        CartPage cartPage = goToCartInProduct(productPage);
        verifyAllProductInCart(cartPage, products);

        LoginSignupPage loginSignupPage = goToLoginPage(cartPage);

        HomePage homePage = fillDetailLogin(loginSignupPage);

        goToCartInHome(homePage);

        verifyAllProductInCart(cartPage, products);
    }

    public ProductPage goToProductPage() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible());
        homePage.clickProduct();
        Assert.assertTrue(homePage.isNavitoProductPage());
        return new ProductPage(driver);
    }

    public ProductPage searchProduct(ProductPage productPage, String keyword) {
        productPage.searchProduct(keyword);
        Assert.assertTrue(productPage.isTitleSearchVisible());
        return new ProductPage(driver);
    }

    public void verifyProductRelatedSearchKey(ProductPage productPage, String keyword, List<String> products) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!products.isEmpty());
        for (String item : products) {
            softAssert.assertTrue(item.toLowerCase().replace(" ", "").replace("-",
                    "").contains(keyword.toLowerCase()));
        }
        softAssert.assertAll();
    }

    public void addAllProductToCart(ProductPage productPage) {
        productPage.addProductsRelatedSearchKey();
    }

    public CartPage goToCartInProduct(ProductPage productPage) {
        productPage.RedirectToCartPage();
        return new CartPage(driver);
    }

    public CartPage goToCartInHome(HomePage homePage) {
        homePage.RedirectToCartPage();
        return new CartPage(driver);
    }

    public void verifyAllProductInCart(CartPage cartPage, List<String> products) {
        List<String> productCart = cartPage.verifyProduct();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!productCart.isEmpty());
        for (int i = 0; i < productCart.size(); i++) {
            softAssert.assertTrue(productCart.get(i).contains(products.get(i)));
        }
        softAssert.assertAll();
    }

    public LoginSignupPage goToLoginPage(CartPage cartPage) {
        cartPage.clickSignupLogin();
        return new LoginSignupPage(driver);
    }

    public HomePage fillDetailLogin(LoginSignupPage loginSignupPage) {
        loginSignupPage.login("channel@gmail.com", "18042004");
        return new HomePage(driver);
    }
}
