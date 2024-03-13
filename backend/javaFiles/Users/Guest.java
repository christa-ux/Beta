package backend.javaFiles.Users;

class Guest extends User {
    public Guest(String username) {
        super(username);
        permissions.add(Permission.TURN_ON_OFF_LIGHTS);
        permissions.add(Permission.OPEN_CLOSE_WINDOWS);
    }

    @Override
    public String getUserType() {
        return "Guest";
    }
}
