package backend.javaFiles.Users;

public class Stranger extends User {
    public Stranger(String username) {
        super(username);
    }
    
@Override
    public String getUserType() {
        return "Stranger";
    }
}
