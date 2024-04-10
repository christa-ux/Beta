package Backend.Users;

// Child.java
public class Child extends User {
    public Child(String username, String password) {
        super(username, password, UserType.CHILD);
    }
}

