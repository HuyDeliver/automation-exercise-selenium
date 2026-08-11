package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import Utils.UserData;

public class EnterAccountInfoPage {
    private WebDriver driver;

    private By titleEnterAccountInfo = By.xpath("//b[text()='Enter Account Information']");

    private By maleTitle = By.id("id_gender1");
    private By femaleTitle = By.id("id_gender2");
    private By password = By.id("password");

    private By day = By.id("days");
    private By month = By.id("months");
    private By year = By.id("years");

    private By newsletter = By.id("newsletter");
    private By optin = By.id("optin");

    private By typeFirstName = By.id("first_name");
    private By typeLastName = By.id("last_name");
    private By typeCompany = By.id("company");
    private By typeAddress1 = By.id("address1");
    private By typeAddress2 = By.id("address2");
    private By chooseCountry = By.name("country");
    private By typeState = By.id("state");
    private By typeCity = By.id("city");
    private By typeZipcode = By.id("zipcode");
    private By typeMobileNumber = By.id("mobile_number");
    private By submitaccountInfo = By.xpath("//button[text()='Create Account']");

    public EnterAccountInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isEnterAccountInfoVisible() {
        return !driver.findElements(titleEnterAccountInfo).isEmpty();
    }

    public void fillAccountInfo(UserData user) {
        if ("Mrs".equalsIgnoreCase(user.getTitle())) {
            driver.findElement(femaleTitle).click();
        } else {
            driver.findElement(maleTitle).click();
        }

        driver.findElement(password).sendKeys(user.getPassword());

        new Select(driver.findElement(day)).selectByVisibleText(user.getDay());
        new Select(driver.findElement(month)).selectByVisibleText(user.getMonth());
        new Select(driver.findElement(year)).selectByVisibleText(user.getYear());

        if (user.isNewsletter() && !driver.findElement(newsletter).isSelected()) {
            driver.findElement(newsletter).click();
        }

        if (user.isOptin() && !driver.findElement(optin).isSelected()) {
            driver.findElement(optin).click();
        }
    }

    public void fillAddressInfo(UserData user) {
        driver.findElement(typeFirstName).sendKeys(user.getFirstName());
        driver.findElement(typeLastName).sendKeys(user.getLastName());
        driver.findElement(typeCompany).sendKeys(user.getCompany());
        driver.findElement(typeAddress1).sendKeys(user.getAddress1());
        if (user.getAddress2() != null && !user.getAddress2().trim().isEmpty()) {
            driver.findElement(typeAddress2).sendKeys(user.getAddress2());
        }
        new Select(driver.findElement(chooseCountry)).selectByVisibleText(user.getCountry());
        driver.findElement(typeState).sendKeys(user.getState());
        driver.findElement(typeCity).sendKeys(user.getCity());
        driver.findElement(typeZipcode).sendKeys(user.getZipcode());
        driver.findElement(typeMobileNumber).sendKeys(user.getMobileNumber());
    }

    public CreateAccountSuccess CreateAccount() {
        driver.findElement(submitaccountInfo).click();
        return new CreateAccountSuccess(driver);
    }

}