package api.testingModules;

public class DashboardValues {
    private String name;
    private String description;

    public DashboardValues(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
