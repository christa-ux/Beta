package Backend.Users;

// Parent.java
public class Parent extends User {
    public Parent(String username, String password) {
        super(username, password, UserType.PARENT);
    }
}

