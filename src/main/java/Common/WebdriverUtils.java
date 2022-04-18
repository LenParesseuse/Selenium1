package Common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static Common.Constant.BROWSER;
import static Common.Constant.DRIVER;

public class WebdriverUtils {
    //initiate Driver
    public static void initDriver(String browserName) {
        Constant.BROWSER=browserName.toLowerCase();
        switch (BROWSER) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "Executables/chromedriver.exe");
                DRIVER = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "Executables/geckodriver.exe");
                DRIVER = new FirefoxDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "Executables/chromedriver.exe");
                DRIVER = new ChromeDriver();
                break;
        }
    }

    //navigate to page url
    public static void navigateTo(String url) {
        DRIVER.get(url);
    }

    //maximize window
    public static void maximizeWindow() {
        DRIVER.manage().window().maximize();
    }

    //quit
    public static void quitBrowser() {
        DRIVER.quit();
    }

    //scroll down
    public static void scrollDowntoElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) DRIVER;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }

    //wait
    public void setImplicit(int seconds) {
        DRIVER.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static void waitTillClickable(WebElement element, int second) {
        WebDriverWait wait = new WebDriverWait(DRIVER, second);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitTillVisible(WebElement element, int second) {
        WebDriverWait wait = new WebDriverWait(DRIVER, second);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //get the current URL
    public static String getUrlOfPage() {
        return DRIVER.getCurrentUrl();
    }

}
