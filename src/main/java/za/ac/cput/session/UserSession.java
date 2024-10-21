package za.ac.cput.session;

import za.ac.cput.domain.Admin;

public class UserSession {
    private static UserSession instance;
    private Admin currentUser;

    private UserSession() {}

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void setCurrentUser(Admin user) {
        this.currentUser = user;
    }

    public Admin getCurrentUser() {
        return currentUser;
    }
}
