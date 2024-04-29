package Backend.Users;
public class Guest extends User {
    public Guest(String username, String password) {
        super(username, password, UserType.GUEST);
    }
}
