package TestCase1;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.ContactForm;
import Pages.HomePage;

public class ContactTest extends BaseTest {
    @Test
    public void fillContact() {
        HomePage homePage = new HomePage(driver);
        ContactForm contactForm = new ContactForm(driver);

        homePage.contactUs();
        Assert.assertTrue(contactForm.isTitleContactShow());
        contactForm.getInTouch("Nguyễn Huy Phát", "Channelbaby15@gmail.com", "Feedback về web",
                "Ứng dụng rất tuyệt vời, xin hãy tiếp tục phát huy",
                "C:\\Users\\admin\\OneDrive\\Tài liệu\\Nguyen-Huy-Phat-Intern-Tester.pdf");

        contactForm.contactConfirm();
        Assert.assertTrue(contactForm.isConfirmContactSuccess());

        contactForm.redirectHomePage();
        Assert.assertTrue(contactForm.isNavitoHomePage("https://automationexercise.com"));

    }
}
