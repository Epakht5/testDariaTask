package ui.properties;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DataReader {
    public static DataReader value;
    private String login;
    private String password;
    private String dashboardName;
    private String dashboardDescription;
    private String browserMode;

    static {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            value = objectMapper.readValue(new File("src/main/resources/data.json"), DataReader.class);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public String getLogin() {
        return value.login;
    }

    public String getBrowserMode() {
        return value.browserMode;
    }

    public String getPassword() {
        return value.password;
    }

    public String getDashboardName() {
        return value.dashboardName;
    }

    public String getDashboardDescription() {
        return value.dashboardDescription;
    }
}
