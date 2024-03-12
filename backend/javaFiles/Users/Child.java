package backend.javaFiles.Users;

class Child extends User {
    public Child(String username) {
        super(username);
    }

    @Override
    public String getUserType() {
        return "Child";
    }
}
