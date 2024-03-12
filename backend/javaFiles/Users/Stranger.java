package backend.javaFiles.Users;

class Stranger extends User {
    public Stranger(String username) {
        super(username);
    }

    @Override
    public String getUserType() {
        return "Stranger";
    }
}
