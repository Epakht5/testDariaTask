package testCases;

import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.pages.RegistrationPage;
import ui.pages.ReportPortalMainMenu;

import static org.junit.jupiter.api.Assertions.*;

public class DashboardTestUI extends BaseTest{

    private RegistrationPage registrationPage;
    private ReportPortalMainMenu reportPortalMainMenu;

    @BeforeEach
    public void initializePages(){
        registrationPage = new RegistrationPage();
        reportPortalMainMenu = new ReportPortalMainMenu();
    }

    @Test
    @Description("Войти в систему Report Portal (логин: default; пароль: 1q2w3e).\n" +
            "Перейти на существующий Dashboard.\n" +
            "Добавить новый Widget типа \"Task Progress\".\n" +
            "Проверить, что Widget успешно добавлен и отображается на Dashboard.\n")
    public void dashboardTesting(){

        registrationPage.fillLogin();

        registrationPage.fillPassword();

        registrationPage.clickOnSubmit();
        assertTrue(reportPortalMainMenu.isMainMenuUniqueElementLocated(), "Ошибка при попадании на основную страницу");

        reportPortalMainMenu.clickOnDashboardCategory();
        assertTrue(reportPortalMainMenu.isDashboardMenuLocated(), "Категория Dashboard не открыта");

        reportPortalMainMenu.clickOnAddNewDashboard();

        reportPortalMainMenu.fillNameDashboard();

        reportPortalMainMenu.fillDescriptionDashboard();

        reportPortalMainMenu.clickOnAddDashboard();

        reportPortalMainMenu.clickOnDashboardCategory();
        assertTrue(reportPortalMainMenu.isWidgetDashboardLocated(), "Widget dashboard нет в списке");
    }
}
