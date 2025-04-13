package testCases;

import api.testingModules.DashboardValues;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class DashboardTestAPI {
    private static final String API_KEY = "testing_Q9jzvlcmRfu4IeaTHjbeVSQ-ko95jZSsHdkF0Mm6-FoLBGK6QSNTPbQSgGAv_8IJ";
    private static final String URL = "https://demo.reportportal.io";
    private static final String PROJECT_NAME = "default_personal";

    @Test
    @Description("Выполнить POST запрос к эндпоинту /api/v1/dashboards с необходимыми данными (см. документацию в разделе Ресурсы).\n" +
            "Проверить, что Dashboard успешно создан (статус код 201) и присутствует в списке Dashboard'ов\n")
    public void creatingDashboardPositiveTest(){
        RestAssured.baseURI = URL;
        DashboardValues dashboardCreating = new DashboardValues("Hello", "What are u doing here?");
        String nameOfDashboard = dashboardCreating.getName();

        Response creatingDashboard = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + API_KEY)
                .body(dashboardCreating)
                .when()
                .post("/api/v1/" + PROJECT_NAME + "/dashboard")
                .then().log().body()
                .extract().response();
        assertEquals(201, creatingDashboard.getStatusCode(), "Неккоректное создание Dashboard, код ответа не 201");

        System.out.println(" ");

        Response dashboardsList = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + API_KEY)
                .when()
                .get("/api/v1/" + PROJECT_NAME + "/dashboard")
                .then()
                .extract().response();
        List<String> dashboardNames = dashboardsList.jsonPath().getList("content.name");

        assertTrue(dashboardNames.contains(nameOfDashboard), "Созданный dashboard не найден в списке");
    }

    @Test
    @Description("Выполнить POST запрос к эндпоинту /api/v1/dashboards с пропущенными обязательными параметрами (см. документацию в разделе Ресурсы).\n" +
            "Проверить, что Dashboard не создан (например, статус код 400).\n" +
            "Убедиться, что Dashboard с неполными параметрами не существует в списке Dashboard'ов.\n")
    public void creatingDashboardNegativeTest(){
        RestAssured.baseURI = URL;
        DashboardValues dashboardCreating = new DashboardValues(null, null);

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + API_KEY)
                .body(dashboardCreating)
                .when()
                .post("/api/v1/" + PROJECT_NAME + "/dashboard")
                .then().log().body()
                .extract().response();
        assertEquals(400, response.getStatusCode(), "Ожидался код ответа 400");

        Response dashboardsList = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + API_KEY)
                .when()
                .get("/api/v1/" + PROJECT_NAME + "/dashboard")
                .then().extract().response();
        List<String> dashboardNames = dashboardsList.jsonPath().getList("content.name");

        boolean exists = dashboardNames.contains(dashboardCreating.getName()) || dashboardNames.contains(dashboardCreating.getDescription());
        assertFalse(exists, "Dashboard был создан с невалидными параметрами");
    }
}
