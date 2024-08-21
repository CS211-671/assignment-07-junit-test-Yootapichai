package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        // Create a UserList and add users
        UserList userList = new UserList();
        userList.addUser("user1", "password1");
        userList.addUser("user2", "password2");
        userList.addUser("user3", "password3");

        // Find one of them
        User user = userList.findUserByUsername("user2");

        // Assert that UserList found User
        String expected = "user2";
        String actual = user.getUsername();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        // Create a UserList and add users
        UserList userList = new UserList();
        userList.addUser("user1", "password1");
        userList.addUser("user2", "password2");
        userList.addUser("user3", "password3");

        // Change password of one user
        boolean actual = userList.changePassword("user2", "password2", "newpassword");

        // Assert that user can change password
        assertTrue(actual);

        // Verify that the new password works
        User user = userList.login("user2", "newpassword");
        assertNotNull(user);
    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        // Create a UserList and add users
        UserList userList = new UserList();
        userList.addUser("user1", "password1");
        userList.addUser("user2", "password2");
        userList.addUser("user3", "password3");

        // Call login() with correct username and password
        User user = userList.login("user3", "password3");

        // Assert that User object is found
        assertNotNull(user);
        assertEquals("user3", user.getUsername());
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        // Create a UserList and add users
        UserList userList = new UserList();
        userList.addUser("user1", "password1");
        userList.addUser("user2", "password2");
        userList.addUser("user3", "password3");

        // Call login() with incorrect username or incorrect password
        User user = userList.login("user3", "wrongpassword");

        // Assert that the method returns null
        assertNull(user);
    }
}
