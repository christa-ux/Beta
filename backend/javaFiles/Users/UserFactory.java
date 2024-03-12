package backend.javaFiles.Users;

public class UserFactory {

    public static User createUser(String type, String username) {
        switch (type) {
            case "Parent":
                return new Parent(username);
            case "Child":
                return new Child(username);
            case "Guest":
                return new Guest(username);
            case "Stranger":
                return new Stranger(username);
            default:
                throw new IllegalArgumentException("Unknown user type: " + type);
        }
    }
}