package ku.cs.models;

import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;

    public UserList() {
        users = new ArrayList<>();
    }

    public User findUserByUsername(String username) {
        for (User user : users) {
            if (user.isUsername(username)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(String username, String password) {
        User exist = findUserByUsername(username);
        if (exist == null) {
            users.add(new User(username, password));
        }
    }

    // Implements method to change user's password to newPassword by verifying oldPassword
    // Returns true if process is completed, otherwise returns false
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        User user = findUserByUsername(username);
        if (user != null && user.validatePassword(oldPassword)) {
            user.setPassword(newPassword);
            return true;
        }
        return false;
    }

    // Implements method to find user in users with valid password
    // Returns User object if username and password are correct, otherwise returns null
    public User login(String username, String password) {
        User user = findUserByUsername(username);
        if (user != null && user.validatePassword(password)) {
            return user;
        }
        return null;
    }
}
