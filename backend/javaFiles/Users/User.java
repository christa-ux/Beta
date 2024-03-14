package backend.javaFiles.Users;


//import backend.javaFiles.Permission.Permission;

import java.util.EnumSet;
import java.util.Set;

public abstract class User {
    private String username;
    protected Set<Permission> permissions;

    public User(String username) {
        this.username = username;
        this.permissions = EnumSet.noneOf(Permission.class); // Start with no permissions
    }

    public String getUsername() {
        return username;
    }

    public abstract String getUserType();

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public boolean hasPermission(Permission permission) {
        return permissions.contains(permission);
    }

}
