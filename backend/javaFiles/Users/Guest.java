package backend.javaFiles.Users;

class Guest extends User {
    public Guest(String username) {
        super(username);
    }

    @Override
    public String getUserType() {
        return "Guest";
    }
}
