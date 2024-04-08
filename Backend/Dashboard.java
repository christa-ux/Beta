package Backend;

public class Dashboard {
    private static Dashboard instance;
    private Dashboard() {
    }
    public static Dashboard getInstance() {
        if (instance == null) {
            instance = new Dashboard();
        }
        return instance;
    }
}
