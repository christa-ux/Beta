package Backend.Users;
import java.util.EventListener;
public interface LoginListener extends EventListener {
    void loginPerformed(LoginEvent event);
    // void onLoginSuccess();
}