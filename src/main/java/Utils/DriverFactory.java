package Utils;

import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverFactory {
    public static WebDriver createDriver() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments(
                "--host-resolver-rules=" +
                        "MAP *.doubleclick.net 127.0.0.1," +
                        "MAP *.googlesyndication.com 127.0.0.1," +
                        "MAP *.googleadservices.com 127.0.0.1," +
                        "MAP *.google-analytics.com 127.0.0.1," +
                        "MAP *.googletagmanager.com 127.0.0.1," +
                        "MAP *.googletagservices.com 127.0.0.1," +
                        "MAP *.adnxs.com 127.0.0.1," +
                        "MAP *.adsystem.com 127.0.0.1");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        WebDriver driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
