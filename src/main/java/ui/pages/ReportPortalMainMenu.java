package ui.pages;

import ui.elements.Button;
import ui.elements.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.properties.SingletonDriver;
import ui.properties.DataReader;

import java.time.Duration;

public class ReportPortalMainMenu{

    private String uniqueReportPortalMainMenuElement = "//div[@class='layout__corner-area--vBGle']";
    private String dashboard = "(//*[@class='sidebarButton__sidebar-nav-btn--gbV_N'])[1]";
    private String newDashboard = "//button[@class='ghostButton__ghost-button--r7c9T ghostButton__color-topaz--Z_OvX with-icon ghostButton__filled-icon--HoBWw ghostButton__mobile-minified--d60VQ']";
    private String nameDashboard = "//input[@placeholder='Enter dashboard name']";
    private String descriptionDashboard = "//textarea[@placeholder='Enter dashboard description']";
    private String addDashboard = "//button[@class='bigButton__big-button--BmG4Q bigButton__color-booger--EpRlL']";
    private String widget = "//*[contains(text(),'Task Progress')]/preceding-sibling::*[contains(text(),'Widget')]";

    public boolean isMainMenuUniqueElementLocated(){
        new WebDriverWait(SingletonDriver.getInstance().getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(uniqueReportPortalMainMenuElement)));
        return SingletonDriver.getInstance().getDriver().findElement(By.xpath(uniqueReportPortalMainMenuElement)).isDisplayed();
    }

    public void clickOnDashboardCategory(){
        new Button(dashboard).click();
    }

    public boolean isDashboardMenuLocated(){
        new WebDriverWait(SingletonDriver.getInstance().getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(newDashboard)));
        return SingletonDriver.getInstance().getDriver().findElement(By.xpath(newDashboard)).isDisplayed();
    }

    public void clickOnAddNewDashboard(){
        new WebDriverWait(SingletonDriver.getInstance().getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(newDashboard)));
        new Button(newDashboard).click();
    }

    public void fillNameDashboard(){
        new TextBox(nameDashboard).sendKeys(new DataReader().getDashboardName());
    }

    public void fillDescriptionDashboard(){
        new TextBox(descriptionDashboard).sendKeys(new DataReader().getDashboardDescription());
    }

    public void clickOnAddDashboard(){
        new Button(addDashboard).click();
    }

    public boolean isWidgetDashboardLocated(){
        new WebDriverWait(SingletonDriver.getInstance().getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(widget)));
        return SingletonDriver.getInstance().getDriver().findElement(By.xpath(widget)).isDisplayed();
    }
}
