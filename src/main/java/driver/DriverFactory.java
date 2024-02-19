package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v121.io.IO;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Locale;
import java.util.Properties;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createWebdriver());
        }

        return webDriver.get();
    }

    private static WebDriver createWebdriver() {
        WebDriver driver = null;

        switch (getBrowserType()) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/chromedriver" + (System.getProperty("os.name").contains("win") ? ".exe" : ""));
                ChromeOptions chromeOptions = getChromeOptions();
                driver = new ChromeDriver(chromeOptions);
            }
            case "firefox" -> {
//              If your system need to use a specific geckodriver, you can put it in the "drivers" folder and uncomment the next line
//              System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/geckodriver" + (System.getProperty("os.name").contains("win") ? ".exe" : ""));
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(firefoxOptions);
            }
        }

        driver.manage().window().maximize();

        return driver;
    }

    private static String getBrowserType() {
        String browserType = System.getProperty("browserType");

        try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties")) {
            if (browserType == null || browserType.isEmpty()) {
                Properties properties = new Properties();
                properties.load(fis);

                browserType = properties.getProperty("browser").toLowerCase().trim();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return browserType;
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.setBinary("/home/marcelo/Downloads/google-chrome/chrome");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("disable-infobars"); // disabling info bars
        chromeOptions.addArguments("--disable-extensions"); // disabling extensions
        chromeOptions.addArguments("--disable-gpu"); // applicable to Windows os only
        chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model
        return chromeOptions;
    }

    public static void cleanupDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }
}
