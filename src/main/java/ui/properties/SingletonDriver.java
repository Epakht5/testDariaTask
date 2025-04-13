package ui.properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SingletonDriver {
    private static SingletonDriver instance = null;
    private static WebDriver driver;

    private SingletonDriver() {
        String browserType = new DataReader().getBrowserMode();
        if ("chrome".equalsIgnoreCase(browserType)) {
            initializeChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browserType)) {
            initializeFirefoxDriver();
        } else {
            throw new IllegalArgumentException("Неподдерживаемый тип браузера: " + browserType);
        }
    }

    private void initializeChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    private void initializeFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        driver = new FirefoxDriver(options);
    }

    public static SingletonDriver getInstance() {
        if (instance == null) {
            instance = new SingletonDriver();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            instance = null;
        }
    }
}
