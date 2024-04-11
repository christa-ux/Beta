package Backend.SMModules;

public interface SHHObserver {
    void update(String roomId, String eventType, Object eventData);
}
