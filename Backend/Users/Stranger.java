package Backend.Users;
// Stranger.java
public class Stranger extends User {
    public Stranger(String username, String password) {
        super(username, password, UserType.STRANGER);
    }
}
