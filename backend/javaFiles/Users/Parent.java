package backend.javaFiles.Users;

import java.util.EnumSet;

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
