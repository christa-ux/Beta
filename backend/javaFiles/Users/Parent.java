package backend.javaFiles.Users;
class Parent extends User {
    public Parent(String username) {
        super(username);
        permissions = EnumSet.allOf(Permission.class); // all permissons for parents
    }

    @Override
    public String getUserType() {
        return "Parent";
    }
}
