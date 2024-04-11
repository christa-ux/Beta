// package Backend.Users;
// import java.util.EventObject;

// import Backend.Users.User.UserType;
// public class LoginEvent extends EventObject {
//     public LoginEvent(Object source) {
//         super(source);
// }

// }
package Backend.Users;

import java.util.EventObject;

public class LoginEvent extends EventObject {
    private User user;

    public LoginEvent(Object source) {
        super(source);

    }

    public User getUser() {
        return user;
    }
}
