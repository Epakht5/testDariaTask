package ui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.properties.SingletonDriver;

import java.time.Duration;

public class BaseElement {

    private final int timeOutInSeconds = 10;
    private String xpath;
    private String elementName;

    public BaseElement(){}

    public BaseElement(String locator){
        this.xpath=locator;
    }

    public BaseElement(String locator, String elementName){
        this.xpath = locator;
        this.elementName = elementName;
    }

    public WebElement isLocated(){
        return new WebDriverWait(SingletonDriver.getInstance().getDriver(), Duration.ofSeconds(timeOutInSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public WebElement isVisible(){
        return new WebDriverWait(SingletonDriver.getInstance().getDriver(), Duration.ofSeconds(timeOutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public void waitForAlertToDisappear() {
        new WebDriverWait(SingletonDriver.getInstance().getDriver(), Duration.ofSeconds(timeOutInSeconds))
                .until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
    }

    public WebElement getElement() {
        return new WebDriverWait(SingletonDriver.getInstance().getDriver(), Duration.ofSeconds(timeOutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public String getElementName() {
        return elementName;
    }

    public WebDriverWait Wait(){
        return new WebDriverWait(SingletonDriver.getInstance().getDriver(), Duration.ofSeconds(timeOutInSeconds));
    }

    public String getText(){
        new WebDriverWait(SingletonDriver.getInstance().getDriver(), Duration.ofSeconds(timeOutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return SingletonDriver.getInstance().getDriver().findElement(By.xpath(xpath)).getText();
    }
}
