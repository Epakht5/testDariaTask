package testCases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import ui.properties.SingletonDriver;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = SingletonDriver.getInstance().getDriver();
        driver.get("https://demo.reportportal.io/ui/#login");
    }

    @AfterEach
    public void tearDown(){
        SingletonDriver.quitDriver();
    }
}
