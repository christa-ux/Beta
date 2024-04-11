package Backend.Users;
import java.io.Serializable;

public class User implements Serializable {  //CRUD on user
  
    private String username; 
    private String password;
    private User.UserType userType;
    User(String username, String password, UserType userType) {
        this.username=username;
        this.password=password;
        this.userType=userType;
    }
    public String getUsername() {
        return username;
    }
    public String getUserPassword() {
        return password;
    }
    public UserType getType() {
        return userType;
    }
    public void setUsername(String username) {
        this.username=username;
    }
    public void setPassword(String password) {
        this.password=password;
    }
    public void setType(UserType userType) {
        this.userType=userType;
    }
    public String toString() {
        return username+" "+password;
    }
     public enum UserType {
        PARENT, 
        CHILD,
        STRANGER, 
        GUEST
    }
}


