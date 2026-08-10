package Utils;

import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    public static WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();

        // Chặn quảng cáo Google
        options.addArguments(
                "--host-resolver-rules=MAP googleads.g.doubleclick.net 127.0.0.1, MAP pagead2.googlesyndication.com 127.0.0.1, MAP adservice.google.com 127.0.0.1");
        // Không đợi load hết tất cả (bỏ qua ads, tracking, ...)
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        // Tắt notification, popup
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }
}
